package ru.toboe512.airlines.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Сущность рейса
 *
 */

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "destination_from", referencedColumnName = "id")
    private Destination destinationFrom;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "destination_to", referencedColumnName = "id")
    private Destination destinationTo;
    @NonNull
    @NotEmpty
    private LocalDateTime departureDateTime;
    @NonNull
    @NotEmpty
    private LocalDateTime arrivalDateTime;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    private Aircraft aircraft;
    @NonNull
    @NotEmpty
    private FlightStatus flightStatus;
    @NonNull
    @NotEmpty
    //todo тут придумать и добавить енам
    private String inflightServices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id.equals(flight.id) &&
                destinationFrom.equals(flight.destinationFrom) &&
                destinationTo.equals(flight.destinationTo) &&
                departureDateTime.equals(flight.departureDateTime) &&
                arrivalDateTime.equals(flight.arrivalDateTime) &&
                aircraft.equals(flight.aircraft) &&
                flightStatus == flight.flightStatus &&
                inflightServices.equals(flight.inflightServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destinationFrom, destinationTo,
                departureDateTime, arrivalDateTime, aircraft,
                flightStatus, inflightServices);
    }
}
