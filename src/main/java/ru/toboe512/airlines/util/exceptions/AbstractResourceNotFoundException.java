package ru.toboe512.airlines.util.exceptions;

public abstract class AbstractResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final String message;

    protected AbstractResourceNotFoundException(final String resourceId) {
        this.message = buildMessage(resourceId);
    }

    protected AbstractResourceNotFoundException() {
        this.message = buildMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String buildMessage(final String resourceId) {
        return getResourceAlias() + " with id " +
                resourceId +
                " is not found.";
    }

    private String buildMessage() {
        return "No " + getResourceAlias() +
                "s are found.";
    }

    protected abstract String getResourceAlias();
}
