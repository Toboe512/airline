package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.toboe512.airlines.entity.BookingRef;

/**
 * Interface BookingRefRepository.
 * Implements BookingRef DAO via Spring Data JPA.
 *
 */
@Repository
public interface BookingRefRepository extends JpaRepository<BookingRef, Long> {
    BookingRef findByRefNumber(String refNumber);
}
