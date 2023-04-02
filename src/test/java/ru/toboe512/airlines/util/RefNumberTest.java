package ru.toboe512.airlines.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.toboe512.airlines.service.BookingRefService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//todo написать тест
class RefNumberTest {

    @Autowired
    private BookingRefService bookingRefService;

    @Test
    void shouldReturnRefNumber() {
        // given

        // when
//        String refNumber = RefNumber.generate();
      //  assertThat(refNumber).isNotBlank();

    }
}