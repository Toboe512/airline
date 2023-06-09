package ru.toboe512.airlines.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.toboe512.airlines.entity.Dto.ErrorResponseDto;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ru.toboe512.airlines.entity.Dto.SeatDto;
import ru.toboe512.airlines.entity.SeatCategory;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

/**
 * Declares Seat API methods.
 *
 */
@Tag(name = "Seat Controller")
@RequestMapping(SeatController.BASE_NAME)
public interface SeatController {
    /**
     * Major API version.
     */
    String MAJOR_VERSION = "/v1";
    /**
     * Base API name.
     */
    String BASE_NAME = MAJOR_VERSION + "/seat";

    /**
     * This method creates a new seat.
     *
     * @param seatDTO SeatDto
     * @return SeatDto
     */
    @PostMapping
    @Operation(summary = "Create seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Seat successfully created", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = SeatDto.class)

            )),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<HttpStatus> createSeat(@RequestBody SeatDto seatDTO);

    /**
     * This method updates the seat.
     *
     * @param seatDTO SeatDto
     * @return SeatDto
     */
    @PutMapping
    @Operation(summary = "Update seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seat successfully updated", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = SeatDto.class)
            )),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<HttpStatus> updateSeat(@RequestBody SeatDto seatDTO);

    /**
     * This method deletes the seat by id.
     *
     * @param id Id
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete seat by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Seat successfully deleted", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = SeatDto.class)
            )),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<HttpStatus> deleteSeat(@PathVariable("id") Long id);

    /**
     * This method returns all seats on the flight by Flight id.
     *
     * @param flightId Long
     * @return List<SeatDto>
     */
    @GetMapping("/{flight_id}")
    @Operation(summary = "Getting all seats on the flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seats successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Data not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<List<SeatDto>> getAllSeatsOnFlight(@PathVariable("flight_id") Long flightId);

    /**
     * This method returns all seats of a certain category on a flight by Flight id & Seat category.
     *
     * @param flightId Long
     * @param seatCategory SeatCategory
     * @return List<SeatDto>
     */
    @GetMapping("/v1/seats/flight/{flight_id}/category/{seat_category}")
    @Operation(summary = "Getting all seats of a certain category on a flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seats successfully returned", content = @Content),
            @ApiResponse(responseCode = "400", description = "Data not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<List<SeatDto>> getSeatsOnFlightByCategory(@PathVariable("flight_id") Long flightId, @PathVariable("seat_category") SeatCategory seatCategory);

    /**
     * This method returns a number of sold seats on a flight by flightId.
     *
     * @param flightId Long
     * @return int
     */
    @GetMapping("/sold/{flight_id}")
    @Operation(summary = "Getting a number of sold seats on a flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "A number of sold seats successfully returned",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Data not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<Integer> getNumberOfSoldSeats(@PathVariable("flight_id") Long flightId);

    /**
     * This method returns a number of unsold seats on a flight by flightId.
     *
     * @param flightId Long
     * @return int
     */
    @GetMapping("/unsold/{flight_id}")
    @Operation(summary = "Getting a number of unsold seats on a flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "A number of unsold seats successfully returned",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Data not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<Integer> getNumberOfUnsoldSeats(@PathVariable("flight_id") Long flightId);

    /**
     * This method returns a number of registered passengers on a flight by flightId.
     *
     * @param flightId Long
     * @return int
     */
    @GetMapping("/registered/{flight_id}")
    @Operation(summary = "Getting a number of registered passengers on a flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "A number of registered passengers successfully returned",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Data not found", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    ResponseEntity<Integer> getNumberOfRegisteredPassengersOnFlight(@PathVariable("flight_id") Long flightId);
}
