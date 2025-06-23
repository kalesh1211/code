package in.juvanta.review_ingestion_service.repository;

import in.juvanta.review_ingestion_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
