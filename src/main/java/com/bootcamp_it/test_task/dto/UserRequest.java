package com.bootcamp_it.test_task.dto;

import com.bootcamp_it.test_task.entities.Role;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    @NotBlank
    @Size(max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String surname;
    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String name;
    @NotBlank
    @Size(max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String patronymic;
    @Email
    @Size(max = 50)
    private String email;
    @NotNull
    private Role role;
}
