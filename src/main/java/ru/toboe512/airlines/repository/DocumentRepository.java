package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.toboe512.airlines.entity.Document;

/**
 * Interface DocumentRepository.
 * Implements Document DAO via Spring Data JPA.
 *
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
