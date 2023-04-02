package ru.toboe512.airlines.entity.Dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import ru.toboe512.airlines.entity.DocumentType;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class DocumentDto.
 * Implements Document Response Dto.
 *
 */
@Value
@Schema(description = "Document DTO")
@ToString
public class DocumentDto {

    @Schema(description = "Document Id", example = "1", type = "Long")
    @JsonProperty("id")
    Long id;

    @Schema(description = "Document Type", example = "NATIONAL_PASSPORT", type = "Enum")
    @JsonProperty("type")
    DocumentType type;

    @Schema(description = "Document number", example = "A1B2", type = "String")
    @JsonProperty("number")
    String number;

    @Schema(description = "Document expiry date", example = "2080-12-12", type = "LocalDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("expiry_date")
    LocalDate expiryDate;

    @Schema(description = "Passenger")
    @JsonProperty("passenger")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    //todo Passenger passenger;
    Long passenger;
}
