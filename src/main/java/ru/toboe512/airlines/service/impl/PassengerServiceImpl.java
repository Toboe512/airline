package ru.toboe512.airlines.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.toboe512.airlines.entity.Dto.PassengerDto;
import ru.toboe512.airlines.entity.Passenger;
import ru.toboe512.airlines.repository.PassengerRepository;
import ru.toboe512.airlines.service.PassengerService;
import ru.toboe512.airlines.util.exceptions.PassengerNotFoundException;
import ru.toboe512.airlines.util.mapper.mapStruct.PassengerMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;

    @Override
    public List<PassengerDto> getAllPassengers() {
        return passengerRepository.findAll()
                .stream()
                .map(passengerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException(id));
    }

    @Override
    @Transactional
    public void updatePassenger(Passenger updatedPassenger) {
        Passenger passenger = getPassengerById(updatedPassenger.getId());

        passenger.setFirstName(updatedPassenger.getFirstName());
        passenger.setMiddleName(updatedPassenger.getMiddleName());
        passenger.setLastName(updatedPassenger.getLastName());

        passenger.setUsername(updatedPassenger.getUsername());
        passenger.setPassword(updatedPassenger.getPassword());

        passenger.setDateOfBirth(updatedPassenger.getDateOfBirth());
        passenger.setMobileNumber(updatedPassenger.getMobileNumber());
        passenger.setNickName(updatedPassenger.getNickName());

        passenger.setDocuments(updatedPassenger.getDocuments());

        passengerRepository.save(passenger);
    }

    @Override
    @Transactional
    public void savePassenger(Passenger passenger) {
        passenger.getDocuments().forEach(doc -> doc.setPassenger(passenger));
        passengerRepository.save(passenger);
    }

    @Override
    @Transactional
    public void deletePassengerById(Long id) {
        passengerRepository.delete(getPassengerById(id));
    }
}
