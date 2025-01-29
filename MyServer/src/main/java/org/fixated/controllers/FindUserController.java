package org.fixated.controllers;

import org.fixated.models.user.TableUser;
import org.fixated.services.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class FindUserController {
    private final FindUserService findUserService;

    @Autowired
    public FindUserController(FindUserService findUserService) {
        this.findUserService = findUserService;
    }
    @GetMapping("/role/{role}")
    public List<TableUser> getUsersByRole(@PathVariable("role") String role) {
        return findUserService.getAllManager(role);
    }
}
