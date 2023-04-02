package ru.toboe512.airlines.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.airlines.entity.BookingRef;
import ru.toboe512.airlines.repository.BookingRefRepository;
import ru.toboe512.airlines.service.BookingRefService;

import java.util.Base64;
import java.util.Random;

/**
 * BookingRef service implementation class.
 *
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class BookingRefServiceImpl implements BookingRefService {

    private static final int MAX_RETRY_COUNT = 3;

    private final BookingRefRepository bookingRefRepository;

    @Transactional
    @Override
    public String createRefNumber() {
        BookingRef bookingRef = new BookingRef();
        bookingRef.setRefNumber(generateRefNumber());
        bookingRef = bookingRefRepository.saveAndFlush(bookingRef);
        return bookingRef.getRefNumber();
    }

    /**
     * Make sure that refNumber is unique.
     */
    private String generateRefNumber() {
        String refNumber = makeRefNumber();
        boolean isDuplicate = false;
        for (int i = 1; i < MAX_RETRY_COUNT; i++) {
            BookingRef b = bookingRefRepository.findByRefNumber(refNumber);
            if (b != null) {
                isDuplicate = true;
                // try another
                log.warn(String.format("Generated duplicate refNumber='%s'. Retry.", refNumber));
                refNumber = makeRefNumber();
            } else {
                isDuplicate = false;
                break;
            }
        }
        if (isDuplicate) {
            throw new RuntimeException("Booking refNumber generation is failed.");
        }
        return refNumber;
    }


    /**Generates refNumber (just random in Base64).
     *
     * @return
     */
    private String makeRefNumber() {
        byte[] arr = new byte[8];
        Random r = new Random(System.currentTimeMillis());
        r.nextBytes(arr);
        String msg = Base64.getEncoder().encodeToString(arr)
                .toUpperCase().substring(0, arr.length)
                .replace('+', 'A')
                .replace('/', 'B');
        return msg;
    }
}

