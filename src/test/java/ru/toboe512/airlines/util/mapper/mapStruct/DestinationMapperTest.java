package ru.toboe512.airlines.util.mapper.mapStruct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.toboe512.airlines.entity.Destination;
import ru.toboe512.airlines.entity.Dto.DestinationDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DestinationMapperTest {

    @Autowired
    private DestinationMapper destinationMapper;

    private Destination destinationExpected;

    private DestinationDto destinationDtoExpected;

    @BeforeEach
    void setup() {
        destinationDtoExpected = new DestinationDto(1L,
                "Moscow", "23", "Russian", "SVO", "SVO", 3);
        destinationExpected = new Destination(1L,
                "Moscow", "23", "Russian", "SVO", "SVO", 3);

    }

    @Test
    void toModel() {
        var destination = destinationMapper.toModel(destinationDtoExpected);
        assertThat(destinationExpected).isEqualTo(destination);
    }

    @Test
    void toDto() {
        var destinationDto = destinationMapper.toDto(destinationExpected);
        assertThat(destinationDtoExpected).isEqualTo(destinationDto);
    }
}