package org.fixated.controllers;


import org.fixated.models.request.add.AddTempUserRequest;
import org.fixated.models.request.add.AddUserRequest;
import org.fixated.models.response.ApiResponse;
import org.fixated.models.response.ResponseFactory;
import org.fixated.services.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AddUserController {
    private final AddUserService addUserService;
    @Autowired
    public AddUserController(AddUserService addUserService) {
        this.addUserService = addUserService;
    }

    @PostMapping("/adduser")
    public ResponseEntity<ApiResponse> addTempuser(@RequestBody AddTempUserRequest tempUserRequest) {
        try {
            addUserService.addTempUser(tempUserRequest);
            return ResponseFactory.createResponse("Temporarily added in the database", HttpStatus.CREATED);
        }catch (Exception e) {
            return ResponseFactory.createResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/validateuser")
    public ResponseEntity<ApiResponse> validateTempuser(@RequestBody AddTempUserRequest tempUserRequest) {
        try {
            System.out.println(tempUserRequest);
            addUserService.validateTempUser(tempUserRequest);
            return ResponseFactory.createResponse("Validation Successful", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseFactory.createResponse(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
