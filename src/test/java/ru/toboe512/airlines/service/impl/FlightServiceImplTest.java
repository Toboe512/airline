package ru.toboe512.airlines.service.impl;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.toboe512.airlines.entity.Flight;
import ru.toboe512.airlines.repository.FlightRepository;


//@ContextConfiguration(classes = {FlightServiceImpl.class})
//@ExtendWith(SpringExtension.class)
@Log4j2
//todo написать тест
class FlightServiceImplTest {

    @MockBean
    private FlightRepository flightRepository;

    @Autowired
    private FlightServiceImpl flightService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveFlight() {
    }

    @Test
    void updateFlight() {
    }

    @Test
    void getFlightById() {
//        Mockito.doReturn(new Flight())
//                .when(flightRepository)
//                .findById(1L);
    }

    @Test
    void delete() {
    }
}