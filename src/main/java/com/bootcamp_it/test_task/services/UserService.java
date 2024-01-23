package com.bootcamp_it.test_task.services;

import com.bootcamp_it.test_task.dto.UserRequest;
import com.bootcamp_it.test_task.dto.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service processes users data.
 */
public interface UserService {

    /**
     * Add new user to database
     *
     * @param userRequest user's data from controller
     * @return information about saved user
     */
    UserResponse create(UserRequest userRequest);

    /**
     * Get information about all users from the database (a certain number on one page and in sorted form)
     * @return List with information about all users
     */
    List<UserResponse> getAll(Pageable pageable);
}
