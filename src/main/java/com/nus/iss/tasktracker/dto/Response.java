package com.nus.iss.tasktracker.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class Response {

    // Getters and Setters
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private Object body;

    public Response(LocalDateTime timestamp, int status, String error, String message, Object body) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.body   = body;
    }

}

