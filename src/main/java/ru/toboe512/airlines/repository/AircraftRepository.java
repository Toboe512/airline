package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.toboe512.airlines.entity.Aircraft;

/**
 * Репозиторий для работы с сущностью Aircraft
 */

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
