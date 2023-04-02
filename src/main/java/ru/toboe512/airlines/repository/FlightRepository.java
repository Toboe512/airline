package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.toboe512.airlines.entity.Flight;

/**
 * Репозиторий для работы с сущностью Flight
 *
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
