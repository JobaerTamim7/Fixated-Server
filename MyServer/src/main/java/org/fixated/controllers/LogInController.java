package org.fixated.controllers;

import org.fixated.models.response.ApiResponse;
import org.fixated.models.response.AuthRequest;
import org.fixated.models.response.ResponseFactory;
import org.fixated.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class LogInController {
    private final UserService userService;

    @Autowired
    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public ResponseEntity<ApiResponse> userAuth(@RequestBody AuthRequest authRequest){
        try{
            userService.authUser(authRequest.getMail(),authRequest.getPassword());
            return ResponseFactory.createResponse("Log in successful",HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            return ResponseFactory.createResponse(e.getMessage(),HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return ResponseFactory.createResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

