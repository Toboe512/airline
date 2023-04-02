package ru.toboe512.airlines.util.exceptions;

public class DocumentNotFoundException extends AbstractResourceNotFoundException {
    @Override
    protected String getResourceAlias() {
        return "Document";
    }
}
