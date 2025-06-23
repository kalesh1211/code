package in.juvanta.review_ingestion_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockPlacesController {

    @GetMapping("/places/mock")
    public String getMockResponse() {
        return "{\"message\": \"Hello from mock controller!\"}";
    }
}