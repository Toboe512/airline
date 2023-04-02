package ru.toboe512.airlines.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.toboe512.airlines.entity.Document;
import ru.toboe512.airlines.entity.Dto.DocumentDto;
import ru.toboe512.airlines.repository.DocumentRepository;
import ru.toboe512.airlines.service.DocumentService;
import ru.toboe512.airlines.util.exceptions.DocumentNotFoundException;
import ru.toboe512.airlines.util.mapper.mapStruct.DocumentMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class DocumentServiceImpl.
 * Implements DocumentService interface.
 *

 */
@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Override
    public List<DocumentDto> getAllDocuments() {
        return documentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream().map(DocumentMapper.INSTANCE::mapToDocumentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentDto getDocumentById(Long id) {
        return DocumentMapper.INSTANCE.mapToDocumentDto(findDocumentById(id));
    }

    private Document findDocumentById(Long id) {
        return documentRepository
                .findById(id)
                .orElseThrow(DocumentNotFoundException::new);
    }

    @Transactional
    @Override
    public void createDocument(DocumentDto documentDto) {
        documentRepository.saveAndFlush((DocumentMapper.INSTANCE.mapToDocument(documentDto)));
    }

    @Transactional
    @Override
    public void updateDocument(DocumentDto documentDto) {
        var documentToUpdate = findDocumentById(documentDto.getId());
        DocumentMapper.INSTANCE.updateDocumentFromDto(documentDto, documentToUpdate);
        documentRepository.saveAndFlush(documentToUpdate);
    }

    @Transactional
    @Override
    public void deleteDocumentById(Long id) {
        if (findDocumentById(id) != null) {
            documentRepository.deleteById(id);
        }
    }
}
