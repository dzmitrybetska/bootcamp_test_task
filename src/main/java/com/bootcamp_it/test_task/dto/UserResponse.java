package com.bootcamp_it.test_task.dto;

import com.bootcamp_it.test_task.entities.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private Role role;
}
