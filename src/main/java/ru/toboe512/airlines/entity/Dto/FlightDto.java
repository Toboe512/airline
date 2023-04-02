package ru.toboe512.airlines.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import lombok.Value;
import ru.toboe512.airlines.entity.Destination;
import ru.toboe512.airlines.entity.FlightStatus;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * DTO для работы с сущностью рейса
 *
 */
@Value
@Schema(description = "DTO of flight")
public class FlightDto {

    @Schema(description = "id", example = "1", type = "Long")
    Long id;
    @NonNull
    @Schema(description = "destination From")
    //todo связать с сущностью Destination
    Destination destinationFrom;
    @NonNull
    @Schema(description = "destination To")
    //todo связать с сущностью Destination
    Destination destinationTo;
    @NonNull
    @NotEmpty
    @Future
    @Schema(description = "departure Date Time", example = "2022-10-12T17:39:07.474Z", required = true)
    LocalDateTime departureDateTime;
    @NonNull
    @NotEmpty
    @Future
    @Schema(description = "arrival date Time", example = "2022-10-12T17:39:07.474Z", required = true)
    LocalDateTime arrivalDateTime;
    @NonNull
    @Schema(description = "aircraft")
    //TODO связать с сущность Aircraft
    AircraftDto aircraftId;
    @NonNull
    @NotEmpty
    @Schema(description = "flight status", example = "PLANNED", required = true)
    FlightStatus flightStatus;
    @NonNull
    @NotEmpty
    @Schema(description = "flight Services")
    //TODO добавить сущность InflightServices
    String inflightServices;
}
