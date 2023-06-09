package ru.toboe512.airlines.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.toboe512.airlines.controller.DocumentController;
import ru.toboe512.airlines.entity.Dto.DocumentDto;
import ru.toboe512.airlines.service.DocumentService;

import java.util.List;

/**
 * Сlass DocumentControllerImpl.
 * Implements DocumentController interface.
 *
 */
@Log4j2
@RestController
@RequiredArgsConstructor
public class DocumentControllerImpl implements DocumentController {
    /**
     * Document Service.
     */
    private final DocumentService documentService;

    /**
     * Method gets all documents.
     *
     * @return All Documents
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<DocumentDto> getAllDocuments() {
        log.info("executed getAllDocuments() method");
        return documentService.getAllDocuments();
    }

    /**
     * Method gets document by id.
     *
     * @param id Id
     * @return DocumentDto
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    public DocumentDto getDocumentById(@PathVariable Long id) {
        log.info("executed getDocumentById() method");
        return documentService.getDocumentById(id);
    }

    /**
     * Method creates document.
     *
     * @param documentDto DocumentDto
     */
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(DocumentDto documentDto) {
        log.info("executed createDocument() method");
        documentService.createDocument(documentDto);
    }

    /**
     * Method updates document.
     *
     * @param documentDto DocumentDto
     */
    @Override
    @ResponseStatus(HttpStatus.OK)
    public void updateDocument(DocumentDto documentDto) {
        log.info("executed updateDocument() method");
        documentService.updateDocument(documentDto);
    }

    /**
     * Method deletes document by id.
     *
     * @param id Id
     */
    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDocumentById(Long id) {
        log.info("executed deleteDocumentById() method");
        documentService.deleteDocumentById(id);
    }
}
