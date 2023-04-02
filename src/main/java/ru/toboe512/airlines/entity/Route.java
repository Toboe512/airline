package ru.toboe512.airlines.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Сущность Route базыданных
 *
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "destination_from", referencedColumnName = "id")
    Destination destinationFrom;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "destination_to", referencedColumnName = "id")
    Destination destinationTo;

    //todo добавить енам
    @NonNull
    String dayOfWeek;

    @NonNull
    LocalTime departureTime;

    @NonNull
    LocalTime arrivalTime;

    @NonNull
    Integer numberOfSeats;

    @NonNull
    @Embedded
    AircraftType aircraftType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id.equals(route.id) &&
                destinationFrom.equals(route.destinationFrom) &&
                destinationTo.equals(route.destinationTo) &&
                departureTime.equals(route.departureTime) &&
                arrivalTime.equals(route.arrivalTime) &&
                numberOfSeats.equals(route.numberOfSeats) &&
                aircraftType.equals(route.aircraftType);
    }

    @Override
    public int hashCode() {
        //todo сделать нормальный хешкод
        return Objects.hash(id, destinationFrom, destinationTo,
                departureTime, arrivalTime, numberOfSeats, aircraftType);
    }
}
