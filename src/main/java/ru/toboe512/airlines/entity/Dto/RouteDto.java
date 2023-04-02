package ru.toboe512.airlines.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import lombok.Value;
import ru.toboe512.airlines.entity.AircraftType;

import java.time.LocalTime;
import java.util.Objects;

@Value
@Schema(description = "DTO of route")
public class RouteDto {
    @Schema(description = "id", example = "1", type = "Long")
    Long id;

    @Schema(description = "destination From")
    @NonNull
    DestinationDto destinationFrom;

    @NonNull
    @Schema(description = "destination to")
    DestinationDto destinationTo;

    //todo добавить енам
    @NonNull
    String dayOfWeek;

    @NonNull
    @Schema(description = "departure date")
    LocalTime departureTime;

    @NonNull
    @Schema(description = "arrival date")
    LocalTime arrivalTime;

    @NonNull
    @Schema(description = "number of seats")
    Integer numberOfSeats;

    @NonNull
    AircraftType aircraftType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDto routeDto = (RouteDto) o;
        return id.equals(routeDto.id) &&
                destinationFrom.equals(routeDto.destinationFrom) &&
                destinationTo.equals(routeDto.destinationTo) &&
                departureTime.equals(routeDto.departureTime) &&
                arrivalTime.equals(routeDto.arrivalTime) &&
                numberOfSeats.equals(routeDto.numberOfSeats) &&
                aircraftType.equals(routeDto.aircraftType);
    }

    @Override
    public int hashCode() {
        //todo сделать нормальный хешкод
        return Objects.hash(id, destinationFrom, destinationTo, departureTime, arrivalTime, numberOfSeats, aircraftType);
    }
}
