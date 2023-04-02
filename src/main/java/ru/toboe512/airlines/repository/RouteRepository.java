package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.toboe512.airlines.entity.Route;

/**
 * Репозторий для работы с Route
 *
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
