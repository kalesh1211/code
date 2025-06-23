
package in.juvanta.review_ingestion_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ReviewAPIConfig {

    @Bean
    public WebClient reviewWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.example.com")
                .build();
    }
}
