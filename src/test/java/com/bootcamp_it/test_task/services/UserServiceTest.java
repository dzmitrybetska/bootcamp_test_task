package com.bootcamp_it.test_task.services;

import com.bootcamp_it.test_task.arguments.UserCreateArguments;
import com.bootcamp_it.test_task.arguments.UsersGetArguments;
import com.bootcamp_it.test_task.dto.UserRequest;
import com.bootcamp_it.test_task.dto.UserResponse;
import com.bootcamp_it.test_task.entities.User;
import com.bootcamp_it.test_task.mappers.UserMapper;
import com.bootcamp_it.test_task.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Testing methods of the UserService")
public class UserServiceTest {

    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl(userMapper, userRepository);
    }

    @ParameterizedTest
    @ArgumentsSource(UserCreateArguments.class)
    void createUserTest(UserRequest userRequest, User user, UserResponse userResponse) {
        when(userRepository.save(any(User.class)))
                .thenReturn(user);
        UserResponse actualUserResponse = userService.create(userRequest);
        assertEquals(userResponse, actualUserResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(UsersGetArguments.class)
    void getAllUsersTest(User user, UserResponse userResponse, Pageable pageable) {
        Page<User> page = new PageImpl<>(List.of(user), pageable, 1);
        when(userRepository.findAll(pageable))
                .thenReturn(page);
        List<UserResponse> userResponseList = userService.getAll(pageable);
        assertEquals(Collections.singletonList(userResponse), userResponseList);
    }
}
