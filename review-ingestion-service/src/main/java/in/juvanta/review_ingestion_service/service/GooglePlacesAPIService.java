
package in.juvanta.review_ingestion_service.service;

import in.juvanta.review_ingestion_service.dto.googleplaces.apify.GooglePlacesReviewResponse;
import in.juvanta.review_ingestion_service.model.Review;
import in.juvanta.review_ingestion_service.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class GooglePlacesAPIService {

    private final WebClient reviewWebClient;
    private final ReviewRepository reviewRepository;

    @Autowired
    public GooglePlacesAPIService(WebClient reviewWebClient, ReviewRepository reviewRepository) {
        this.reviewWebClient = reviewWebClient;
        this.reviewRepository = reviewRepository;
    }

    public void processReviews(String jobId) {
        reviewWebClient.get()
            .uri(uriBuilder -> uriBuilder.path("/reviews").queryParam("jobId", jobId).build())
            .retrieve()
            .bodyToFlux(GooglePlacesReviewResponse.class)
            .map(this::convertToReview)
            .doOnNext(reviewRepository::save)
            .subscribe();
    }

    private Review convertToReview(GooglePlacesReviewResponse dto) {
        Review review = new Review();
        review.setAuthorName(dto.getName());
        review.setRating(dto.getStars());
        review.setText(dto.getText());
        review.setPublishedDate(dto.getPublishedAtDate());
        return review;
    }
}
