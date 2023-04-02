package ru.toboe512.airlines.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

/**
 * DTO для работы с сущностью Aircraft
 */
@Value
public class AircraftDto {

    @Id
    @Schema(description = "Id of the aircraft.")
    Long id;

    @Schema(description = "Обязательное поле")
    @NotEmpty(message = "On board number should not be empty")
    String onBoardNumber;

    @Schema(description = "Обязательное поле")
    @NotEmpty
    String stamp;

    @Schema(description = "Обязательное поле")
    @NotEmpty
    String model;

    @Schema(description = "Обязательное поле")
    @NotEmpty(message = "Year of release should not be empty")
    @Size(min = 4, max = 4, message = "Year of release must contain 4 characters")
    int yearOfRelease;

    /**
     * Set of seats.
     */
    @NotEmpty
    Set<SeatDto> seats;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AircraftDto that = (AircraftDto) o;
        return yearOfRelease == that.yearOfRelease &&
                Objects.equals(id, that.id) &&
                Objects.equals(onBoardNumber, that.onBoardNumber) &&
                Objects.equals(stamp, that.stamp) &&
                Objects.equals(model, that.model) &&
                Objects.equals(seats, that.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, onBoardNumber, stamp, model, yearOfRelease, seats);
    }
}
