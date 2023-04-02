package ru.toboe512.airlines.util.mapper.mapStruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.toboe512.airlines.entity.Dto.SeatDto;
import ru.toboe512.airlines.entity.Seat;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.toboe512.airlines.entity.SeatCategory.BUSINESS;

/**
 * SeatMapper test class.
 */
@SpringBootTest
public class SeatMapperTest {
    @Autowired
    private SeatMapper seatMapper;

    private SeatDto seatDtoExpected;
    private Seat seatExpected;

    @BeforeEach
    void setUp() {
        seatDtoExpected = new SeatDto(
                1L, 23L, "seatNumber", 123,
                false, true, BUSINESS
        );

        seatExpected = new Seat(1L, 23L, "seatNumber", 123,
                false, true, BUSINESS);
    }

    @Test
    void toDto() {
        var seatDto = seatMapper.toDto(seatExpected);
        assertThat(seatDto).isEqualTo(seatDtoExpected);
    }

    @Test
    void toModel() {
        var seat1 = seatMapper.toModel(seatDtoExpected);
        assertThat(seat1).isEqualTo(seatExpected);
    }
}