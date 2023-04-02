package ru.toboe512.airlines.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * The Seat class represents a seat in an aircraft cabin.
 *
 */

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne(optional = false)
   // @JoinColumn(name = "aircraft_id", nullable = false, referencedColumnName = "id")
//
    private Long aircraftId;

    private String seatNumber;

    private Integer fare;
    private Boolean isRegistered;
    private Boolean isSold;
    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id) &&
                Objects.equals(aircraftId, seat.aircraftId) &&
                Objects.equals(seatNumber, seat.seatNumber) &&
                Objects.equals(fare, seat.fare) &&
                Objects.equals(isRegistered, seat.isRegistered) &&
                Objects.equals(isSold, seat.isSold) &&
                seatCategory == seat.seatCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aircraftId, seatNumber, fare, isRegistered, isSold, seatCategory);
    }
}