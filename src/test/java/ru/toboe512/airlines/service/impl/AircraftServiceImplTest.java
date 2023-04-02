package ru.toboe512.airlines.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.airlines.entity.Aircraft;
import ru.toboe512.airlines.entity.Dto.AircraftDto;
import ru.toboe512.airlines.entity.Dto.SeatDto;
import ru.toboe512.airlines.entity.Seat;
import ru.toboe512.airlines.entity.SeatCategory;
import ru.toboe512.airlines.repository.AircraftRepository;
import ru.toboe512.airlines.service.AircraftService;
import ru.toboe512.airlines.util.mapper.mapStruct.AircraftMapper;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static ru.toboe512.airlines.entity.SeatCategory.BUSINESS;

/**
 * AircraftService test class.
 *
 */
@SpringBootTest
@Slf4j
class AircraftServiceImplTest {

    @MockBean
    private AircraftRepository aircraftRepository;

    @Autowired
    private AircraftService aircraftService;
    private AircraftDto aircraftDto;

    @BeforeEach
    void setUp() {
        SeatDto seatDto1 = new SeatDto(1L, 123L, "Seat Number", 23,
                true, true, BUSINESS);
        SeatDto seatDto2 = new SeatDto(1L, 123L, "Seat Number", 23,
                true, true, BUSINESS);
        var seats = new HashSet<SeatDto>();
        seats.add(seatDto1);
        seats.add(seatDto2);
        aircraftDto = new AircraftDto(1L, "Bord Number", "Stamp", "Model",
                12, seats);
    }

    @Test
    void getAllAircrafts() {

    }

    @Test
    @Transactional
    void saveAircraft() {

    }

    @Test
    @Transactional
    void updateAircraft() {

    }

    @Test
    @Transactional
    void getAircraftByRealId() {

    }

    @Test
    void getAircraftByFakeId() {

    }

    @Test
    void delete() {

    }
}