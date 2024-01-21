package com.bootcamp_it.test_task.mappers;

import com.bootcamp_it.test_task.dto.UserRequest;
import com.bootcamp_it.test_task.dto.UserResponse;
import com.bootcamp_it.test_task.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToUser(UserRequest userRequest);

    UserResponse mapToUserResponse(User user);
}
