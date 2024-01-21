package com.bootcamp_it.test_task.mappers;

import com.bootcamp_it.test_task.dto.UserRequest;
import com.bootcamp_it.test_task.dto.UserResponse;
import com.bootcamp_it.test_task.entities.User;
import org.mapstruct.Mapper;

/**
 * The interface uses Mapstruct to map entities to DTOs and back.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Mapping userRequest to entity.
     *
     * @param userRequest user details
     * @return entity
     */
    User mapToUser(UserRequest userRequest);

    /**
     * Mapping entity to UserResponse
     *
     * @param user user details from the service
     * @return UserResponse
     */
    UserResponse mapToUserResponse(User user);
}
