package org.fixated.controllers;

import org.fixated.models.response.ApiResponse;
import org.fixated.models.request.auth.AuthRequest;
import org.fixated.models.response.ResponseFactory;
import org.fixated.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class LogInController {
    private final LoginService loginService;

    @Autowired
    public LogInController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody AuthRequest authRequest) {
        try{
            loginService.userValidation(authRequest);
            return ResponseFactory.createResponse("Log in successful",HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            return ResponseFactory.createResponse(e.getMessage(),HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return ResponseFactory.createResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

