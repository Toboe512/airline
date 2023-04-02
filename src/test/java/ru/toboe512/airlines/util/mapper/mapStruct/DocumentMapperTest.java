package ru.toboe512.airlines.util.mapper.mapStruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.toboe512.airlines.entity.Document;
import ru.toboe512.airlines.entity.DocumentType;
import ru.toboe512.airlines.entity.Dto.DocumentDto;
import ru.toboe512.airlines.entity.Passenger;
import ru.toboe512.airlines.repository.DocumentRepository;
import ru.toboe512.airlines.repository.PassengerRepository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.toboe512.airlines.entity.DocumentType.NATIONAL_PASSPORT;

/**
 * Class DocumentMapperTest.
 * Tests ru.kataproject.p_sm_airlines_1.util.mapper.mapStruct.DocumentMapper class.
 *
 */
@SpringBootTest
@DisplayName("Tests DocumentMapper.class")
class DocumentMapperTest {

    @Autowired
    private DocumentMapper documentMapper;
    private DocumentDto documentDtoExpected;
    private Document documentExpected;

    @BeforeEach
    void setUp() {
        var localDate = LocalDate.parse("2023-10-10");
        var localTime = LocalTime.parse("12:30:30");
      //  var localDateTime = LocalDateTime.of(localDate, localTime);
        Passenger passenger = new Passenger(1L, "firstName", "middelname", "lastName",
                localDate, "user@domen.com",
                "passowrd","mobileNumber","nickName",
                new ArrayList<>());

        documentExpected = new Document(12L,
                NATIONAL_PASSPORT,
                "A1B2", localDate, passenger, null, null, 1L);
        passenger.setDocuments(List.of(documentExpected, documentExpected));
        documentExpected.setPassenger(passenger);

        documentDtoExpected = new DocumentDto(
                documentExpected.getId(),
                documentExpected.getType(),
                documentExpected.getNumber(),
                documentExpected.getExpiryDate(),
                passenger.getId());
    }

    /**
     * Tests mapToDocument() method.
     */
    @DisplayName("tests mapToDocument() method")
    @Test
    void shouldMapToDocument() {
        var document = documentMapper.mapToDocument(documentDtoExpected);
        assertThat(document).isEqualTo(documentExpected);
    }

    /**
     * Tests mapToDocumentDto() method.
     */
    @DisplayName("tests mapToDocumentDto() method")
    @Test
    void shouldMapToDocumentDto() {
        var document = DocumentMapper.INSTANCE.mapToDocumentDto(documentExpected);
        assertThat(document).isEqualTo(documentDtoExpected);
    }

    /**
     * Tests updateDocumentFromDto() method.
     */
    @DisplayName("tests updateDocumentFromDto() method")
    @Test
    void shouldUpdateDocumentFromDto() {
        Passenger passenger1 = new Passenger();
        passenger1.setLastName("firstName1");
        passenger1.setLastName("lastName1");
        passenger1.setUsername("user@domen.com");

        Passenger passenger2 = new Passenger();
        passenger2.setLastName("firstName2");
        passenger2.setLastName("lastName2");
        passenger2.setUsername("user2@domen.com");

        //todo  написать тест

        // given
//        var document = new Document()
//                .setId(1L)
//                .setType(DocumentType.NATIONAL_PASSPORT)
//                .setNumber("Old")
//                .setExpiryDate(LocalDate.parse("2030-09-09"))
//                .setPassenger(passenger1);
//
//        var documentDto = new DocumentDto(
//                document.getId(),
//                DocumentType.INTERNATIONAL_PASSPORT,
//                "New",
//                LocalDate.parse("2031-09-09"),
//                passenger2.getId());
//
//        // when
//        DocumentMapper.INSTANCE.updateDocumentFromDto(documentDto, document);
//
//        // then
//        assertThat(document)
//                .hasFieldOrPropertyWithValue("id", documentDto.getId())
//                .hasFieldOrPropertyWithValue("type", documentDto.getType())
//                .hasFieldOrPropertyWithValue("number", documentDto.getNumber())
//                .hasFieldOrPropertyWithValue("expiryDate", documentDto.getExpiryDate());
//        assertThat(document.getPassenger().getId()).isEqualTo(documentDto.getPassenger());
    }
}
