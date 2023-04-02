package ru.toboe512.airlines.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "destinations")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "airport_name")
    private String airportName;

    @Column(name = "airport_code")
    private String airportCode;

    @Column(name = "timezone")
    private int timezone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return timezone == that.timezone &&
                Objects.equals(id, that.id) &&
                Objects.equals(city, that.city) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(airportName, that.airportName) &&
                Objects.equals(airportCode, that.airportCode);
    }

    @Override
    public int hashCode() {
        //todo сделать нормальный хешкод
        return Objects.hash(id, city, countryCode, countryName, airportName, airportCode, timezone);
    }
}