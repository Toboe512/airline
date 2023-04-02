package ru.toboe512.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.toboe512.airlines.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
