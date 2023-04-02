package ru.toboe512.airlines.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;
import ru.toboe512.airlines.entity.SeatCategory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Seat DTO
 *
 */
@Value
@Schema(description = "Seat's DTO")
public class SeatDto {
    @Schema(description = "Seat id", example = "1", type = "Long")
    Long id;

    @NotNull
    @Schema(description = "Aircraft", type = "Long")
    Long aircraftId;

    @NotNull
    @NotEmpty
    @Schema(description = "Alpha-numeric seat number", example = "4A", required = true, type = "String")
    String seatNumber;

    @Schema(description = "Seat fare", example = "123", type = "Integer")
    Integer fare;

    @NotNull
    @NotEmpty
    @Schema(description = "Is seat registered?", example = "false", required = true, type = "Boolean")
    Boolean isRegistered;

    @NotNull
    @NotEmpty
    @Schema(description = "Is seat sold?", example = "false", required = true, type = "Boolean")
    Boolean isSold;

    @NotNull
    @NotEmpty
    @Schema(description = "Seat category", example = "ECONOMY", required = true, type = "Enum")
    SeatCategory seatCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDto seatDto = (SeatDto) o;
        return Objects.equals(id, seatDto.id) &&
                Objects.equals(aircraftId, seatDto.aircraftId) &&
                Objects.equals(seatNumber, seatDto.seatNumber) &&
                Objects.equals(fare, seatDto.fare) &&
                Objects.equals(isRegistered, seatDto.isRegistered) &&
                Objects.equals(isSold, seatDto.isSold) &&
                seatCategory == seatDto.seatCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aircraftId, seatNumber, fare, isRegistered, isSold, seatCategory);
    }
}
