package in.juvanta.review_ingestion_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.juvanta.review_ingestion_service.model.Review;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class ReviewJsonController {

    @GetMapping("/places/json")
    public Review getReviewJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new ClassPathResource("sample_google_places_apify.json").getInputStream();
        return mapper.readValue(is, Review.class);
    }
}