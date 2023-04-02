package ru.toboe512.airlines.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Сущность Aircraft
 */

@Entity
@Table(name = "aircraft")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(name = "on_board_number")
    private String onBoardNumber;

    @NonNull
    @NotEmpty
    private String stamp;

    @NonNull
    @NotEmpty
    @Column(name = "model", unique = true, nullable = false)
    private String model;

    @NonNull
    @NotEmpty
    @Column(name = "year_of_release")
    private int yearOfRelease;

    @OneToMany(mappedBy = "aircraftId", cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    @ToString.Exclude
    private Set<Seat> seats = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return yearOfRelease == aircraft.yearOfRelease &&
                Objects.equals(id, aircraft.id) &&
                onBoardNumber.equals(aircraft.onBoardNumber) &&
                stamp.equals(aircraft.stamp) &&
                model.equals(aircraft.model) &&
                Objects.equals(seats, aircraft.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, onBoardNumber, stamp, model, yearOfRelease, seats);
    }
}
