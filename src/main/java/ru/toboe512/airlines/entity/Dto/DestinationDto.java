package ru.toboe512.airlines.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Value
@Schema(description = "DTO of destination")
public class DestinationDto {
    @NotNull
    @Schema(description = "ID of destination")
    Long id;

    @NotNull
    @Schema(description = "city of destination")
    String city;

    @NotNull
    @Schema(description = "country code of destination")
    String countryCode;

    @NotNull
    @Schema(description = "country name of destination")
    String countryName;

    @NotNull
    @Schema(description = "airport name of destination")
    String airportName;

    @NotNull
    @Schema(description = "airport code of destination")
    String airportCode;

    @NotNull
    @Schema(description = "timezone of destination")
    int timezone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationDto that = (DestinationDto) o;
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