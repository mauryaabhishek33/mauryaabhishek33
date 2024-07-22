package org.example;

import java.util.Date;

public class RequestDto {

    Long requestId;
    String message;
    int time;

    public RequestDto() {

    }

    public RequestDto(String message, Long requestId, int time) {
        this.message = message;
        this.requestId = requestId;
        this.time = time;
    }
}
