package ru.toboe512.airlines.util.mapper.mapStruct;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.toboe512.airlines.entity.Aircraft;
import ru.toboe512.airlines.entity.Dto.AircraftDto;
import ru.toboe512.airlines.entity.Dto.SeatDto;
import ru.toboe512.airlines.entity.Seat;
import ru.toboe512.airlines.entity.SeatCategory;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static ru.toboe512.airlines.entity.SeatCategory.BUSINESS;

@SpringBootTest
@DisplayName("Tests AircraftMapperTest.class")
class AircraftMapperTest {

    @Autowired
    private AircraftMapper aircraftMapper;

    private AircraftDto aircraftDtoExpected;

    private Aircraft aircraftExpected;

    @BeforeEach
    void setup() {
        var seatDto1 = new SeatDto(1L, 123L, "123", 12, true, true, BUSINESS);
        var seatDto2 = new SeatDto(1L, 123L, "123", 12, true, true, BUSINESS);
        var seatDtoSeat = new HashSet<SeatDto>();
        seatDtoSeat.add(seatDto1);
        seatDtoSeat.add(seatDto2);
        aircraftDtoExpected = new AircraftDto(12L, "we345", "wesf", "eqws", 21,
                seatDtoSeat);

        var seat1 = new Seat(1L, 123L, "123", 12, true, true, BUSINESS);
        var seat2 = new Seat(1L, 123L, "123", 12, true, true, BUSINESS);
        var seats = new HashSet<Seat>();
        seats.add(seat1);
        seats.add(seat2);
        aircraftExpected = new Aircraft(12L, "we345", "wesf", "eqws", 21,
                seats);
    }

    @Test
    void toModel() {
        var aircraft = aircraftMapper.toModel(aircraftDtoExpected);
        assertThat(aircraftExpected).isEqualTo(aircraft);
    }

    @Test
    void toDto() {
        var aircraftDto = aircraftMapper.toDto(aircraftExpected);
        assertThat(aircraftDtoExpected).isEqualTo(aircraftDto);
    }
}