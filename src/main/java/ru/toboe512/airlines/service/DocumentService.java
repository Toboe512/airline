package ru.toboe512.airlines.service;

import ru.toboe512.airlines.entity.Dto.DocumentDto;

import java.util.List;

/**
 * Interface Document.
 * Declares Document Service API.
 *
 */
public interface DocumentService {
    /**
     * Method gets all documents.
     *
     * @return All Documents
     */
    List<DocumentDto> getAllDocuments();

    /**
     * Method gets document by id.
     *
     * @param id Id
     * @return Document
     */
    DocumentDto getDocumentById(Long id);

    /**
     * Method creates document.
     *
     * @param documentDto DocumentDto
     */
    void createDocument(DocumentDto documentDto);

    /**
     * Method updates document.
     *
     * @param documentDto DocumentDto
     */
    void updateDocument(DocumentDto documentDto);

    /**
     * Method deletes document by id.
     *
     * @param id Id
     */
    void deleteDocumentById(Long id);
}
