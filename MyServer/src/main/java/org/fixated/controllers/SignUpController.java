package org.fixated.controllers;


import org.fixated.models.request.add.AddUserRequest;
import org.fixated.models.response.ApiResponse;
import org.fixated.models.response.ResponseFactory;
import org.fixated.models.user.User;
import org.fixated.models.user.UserFactory;
import org.fixated.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignUpController {
    private final SignupService signupService;

    @Autowired
    public SignUpController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@RequestBody AddUserRequest addUserRequest) {
        try {
            User user = UserFactory.getUser(addUserRequest);
            signupService.addCustomerUser(user);
            return ResponseFactory.createResponse("User added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseFactory.createResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
