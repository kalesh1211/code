
package in.juvanta.review_ingestion_service.controller;

import in.juvanta.review_ingestion_service.service.GooglePlacesAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class GooglePlacesReviewController {

    private final GooglePlacesAPIService googlePlacesAPIService;

    @Autowired
    public GooglePlacesReviewController(GooglePlacesAPIService googlePlacesAPIService) {
        this.googlePlacesAPIService = googlePlacesAPIService;
    }

    @PostMapping("/ingest")
    public String ingestReviews(@RequestParam String jobId) {
        googlePlacesAPIService.processReviews(jobId);
        return "Review ingestion started for jobId: " + jobId;
    }
}
