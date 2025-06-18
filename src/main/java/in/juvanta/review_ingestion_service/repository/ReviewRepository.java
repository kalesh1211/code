package in.juvanta.review_ingestion_service.repository;

import in.juvanta.review_ingestion_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
