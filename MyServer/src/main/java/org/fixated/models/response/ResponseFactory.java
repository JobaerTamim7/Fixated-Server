package org.fixated.models.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
    public static ResponseEntity<ApiResponse> createResponse(String message, HttpStatus status){
        ApiResponse response = new ApiResponse(message,status.value());
        return new ResponseEntity<>(response,status);
    }
}
