package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.toboe512.airlines.entity.Seat;
import org.springframework.stereotype.Repository;

/**
 * Implements Seat DAO via Spring Data JPA.
 *
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
