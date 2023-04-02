package ru.toboe512.airlines.service.impl;

import lombok.RequiredArgsConstructor;
import ru.toboe512.airlines.entity.Destination;
import ru.toboe512.airlines.entity.Dto.SeatDto;
import ru.toboe512.airlines.repository.DestinationRepository;
import ru.toboe512.airlines.service.DestinationService;
import ru.toboe512.airlines.util.exceptions.SeatNotFoundException;
import ru.toboe512.airlines.repository.SeatRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.airlines.entity.SeatCategory;
import ru.toboe512.airlines.service.SeatService;
import ru.toboe512.airlines.entity.Seat;
import org.springframework.stereotype.Service;
import ru.toboe512.airlines.util.mapper.mapStruct.SeatMapper;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements SeatService interface.
 * Changed by:
 */
@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private SeatMapper seatMapper;

    @Override
    public Seat getSeatById(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        return seat.orElseThrow(SeatNotFoundException::new);
    }

    @Override
    @Transactional
    public void saveSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    @Transactional
    public void updateSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    @Transactional
    public void deleteSeat(Seat seat) {
        seatRepository.delete(seat);
    }

    @Override
    public List<SeatDto> getSeatByFlightId(Long flightId) {
        List<Seat> seats = new ArrayList<>(); //todo добавить получение из репозитория
        return seats.stream().map(seatMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public int getNumberOfSoldSeats(Long flightId) {
        return 0;
    }

    @Override
    public int getNumberOfUnsoldSeats(Long flightId) {
        return 0;
    }

    @Override
    public List<SeatDto> getSeatByFlightIdAndCategory(Long flightId, SeatCategory seatCategory) {
        List<Seat> seats = new ArrayList<>(); //todo добавить получение из репозитория
        return seats.stream().map(seatMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public int getNumberOfRegisteredPassengers(Long flightId) {
        return 0;
    }

}
