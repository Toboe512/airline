package ru.toboe512.airlines.service;

import ru.toboe512.airlines.entity.Dto.PassengerDto;
import ru.toboe512.airlines.entity.Passenger;

import java.util.List;

public interface PassengerService {

    List<PassengerDto> getAllPassengers();

    Passenger getPassengerById(Long id);

    void updatePassenger(Passenger updatedPassenger);

    void savePassenger(Passenger passenger);

    void deletePassengerById(Long id);
}
