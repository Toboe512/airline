package ru.toboe512.airlines.util.mapper.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.toboe512.airlines.entity.Document;
import ru.toboe512.airlines.entity.Dto.DocumentDto;
import ru.toboe512.airlines.entity.Passenger;

/**
 * Interface DocumentMapper.
 * Declares Document mapper between Document and DocumentDto via MapStruct.
 *
 */
@Mapper(componentModel = "spring", uses = DocumentMapper.class)
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    /**
     * Method maps DocumentDto to Document.
     *
     * @param documentDto DocumentDto
     * @return Document
     */
    @Mapping(source = "passenger", target = "passenger.id")
    Document mapToDocument(DocumentDto documentDto);

    /**
     * Maps passenger id to Passenger
     * @param value passenger id
     * @return Passenger
     */
    default Passenger map(Long value) {
        Passenger passenger = new Passenger();
        passenger.setId(value);
        return passenger;
    }

    /**
     * Method maps Document to DocumentDto.
     *
     * @param document Document
     * @return DocumentDto
     */
    @Mapping(source = "passenger.id", target = "passenger")
    DocumentDto mapToDocumentDto(Document document);

    /**
     * Method updates Document from DocumentDto.
     *
     * @param documentDto DocumentDto
     * @param document    Document
     */
    void updateDocumentFromDto(DocumentDto documentDto, @MappingTarget Document document);
}
