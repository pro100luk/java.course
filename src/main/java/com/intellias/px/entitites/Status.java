package com.intellias.px.entitites;

import java.util.Map;

public enum Status {

    NEW(0),
    IN_PROCESSING(100),
    IN_PAYMENT(10),
    PAID(660),
    IN_DELIVERY(4660),
    DELIVERED(50);

    private static final Map<Integer,Status> statusCodeToStatus;

    private final int statusCode;

    Status(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Status fromStatusCOde(int statusCode){
        return statusCodeToStatus.get(statusCode);
}
