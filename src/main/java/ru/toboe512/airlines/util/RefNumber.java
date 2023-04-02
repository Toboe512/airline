package ru.toboe512.airlines.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.toboe512.airlines.service.BookingRefService;

@Component
public class RefNumber implements ApplicationContextAware {

    private static ApplicationContext ac;

    public static String generate() {
        return ((BookingRefService) ac.getBean("bookingRefServiceImpl")).createRefNumber();
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) {
        RefNumber.ac = ac;
    }
}
