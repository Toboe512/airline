package ru.toboe512.airlines.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AircraftType {
    private String iataCode;

    private String model;

    private String range;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AircraftType that = (AircraftType) o;
        return Objects.equals(iataCode, that.iataCode) &&
                Objects.equals(model, that.model) &&
                Objects.equals(range, that.range);
    }

    @Override
    public int hashCode() {
        //todo сделать нормальный хешкод
        return Objects.hash(iataCode, model, range);
    }
}
