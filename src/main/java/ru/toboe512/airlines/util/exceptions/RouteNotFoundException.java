package ru.toboe512.airlines.util.exceptions;

public class RouteNotFoundException extends AbstractResourceNotFoundException {
    @Override
    protected String getResourceAlias() {
        return "Route";
    }
}
