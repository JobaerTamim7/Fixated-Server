package org.fixated.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class ApiResponse {
    @JsonProperty("message")
    private String message;
    @JsonProperty("time_stamp")
    private Instant timestamp;
    @JsonProperty("status_code")
    private int status;

    public ApiResponse(String message, int status){
        this.message = message;
        this.status = status;
        this.timestamp = Instant.now();
    }
}
