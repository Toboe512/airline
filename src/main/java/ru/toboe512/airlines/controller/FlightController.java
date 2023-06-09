package ru.toboe512.airlines.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.toboe512.airlines.entity.Dto.ErrorResponseDto;
import ru.toboe512.airlines.entity.Dto.FlightDto;
import ru.toboe512.airlines.entity.Seat;

/**
 * Контроллер для обработки запросов по добавлению, изминению и получению данных рейса
 *
 */
@Tag(name = "Flight Controller")
@RequestMapping(FlightController.BASE_NAME)
public interface FlightController {
    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/flight";

    /**
     * Получение рейса по ID
     *
     * @param id идентификатор рейса
     * @return ResponseEntity<FlightDTO>
     */
    @GetMapping()
    @Operation(method = "GET", summary = "Get flight by id", description = "Get flight by id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page successfully returned", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FlightDto.class)
            )),
            @ApiResponse(responseCode = "400", description = "Page not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<FlightDto> getFlightById(Long id);

    /**
     * Метод создания нового рейса
     *
     * @param flight данные рейса
     * @return ResponseEntity<HttpStatus>
     */
    @PostMapping
    @Operation(method = "POST", summary = "Create flight ",
            description = "Create flight ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Page not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<HttpStatus> createFlight(@RequestBody FlightDto flight);

    /**
     * Метод изменения рейса
     *
     * @param flight данные рейса
     * @return ResponseEntity<HttpStatus>
     */
    @PatchMapping
    @Operation(summary = "Update flight ",
            description = "Update flight ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Page not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<HttpStatus> updateFlight(@RequestBody FlightDto flight);

    /**
     * Метод удалеиния рейса по id
     *
     * @param id идентификатор рейса
     * @return ResponseEntity<HttpStatus>
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete fight", description = "Delete flight by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Page not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<HttpStatus> deleteFlightById(@PathVariable("id") Long id);

    /**
     * Метод получения сводобных мест в рейсе
     *
     * @param flight данные рейса
     * @return ResponseEntity<String>
     */
    @GetMapping("/seats")
    @Operation(summary = "Getting free seats on the flight",
            description = "Getting free seats on the flight ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Page not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<Seat> getFreeSeatsOnFlight(@RequestBody FlightDto flight);
}
