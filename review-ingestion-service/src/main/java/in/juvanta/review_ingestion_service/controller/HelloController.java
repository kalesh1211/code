
package in.juvanta.review_ingestion_service.controller;

import in.juvanta.review_ingestion_service.service.UserService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "✅ App is running. Try /hello, /api/users, /places/mock";
    }

    @GetMapping("/hello")
    public String hello() {
        return "👋 Hello from Review Ingestion Service!";
    }

    @GetMapping("/api/users")
    public ResponseEntity<String> getUsersFromJson() {
        try {
            ClassPathResource resource = new ClassPathResource("sample_google_places_apify.json");
            String json = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            return ResponseEntity.ok(json);
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to read JSON file: " + e.getMessage());
        }
    }
}
