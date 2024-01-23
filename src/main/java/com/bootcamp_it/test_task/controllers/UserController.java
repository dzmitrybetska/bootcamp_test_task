package com.bootcamp_it.test_task.controllers;

import com.bootcamp_it.test_task.dto.UserRequest;
import com.bootcamp_it.test_task.dto.UserResponse;
import com.bootcamp_it.test_task.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    public final UserService userService;

    @PostMapping(value = "/user")
    public UserResponse create(@Valid @RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping(value = "/users")
    public List<UserResponse> getAll(@PageableDefault(sort = "email") Pageable pageable) {
        return userService.getAll(pageable);
    }
}
