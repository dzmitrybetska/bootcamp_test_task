package com.bootcamp_it.test_task.services;

import com.bootcamp_it.test_task.dto.UserRequest;
import com.bootcamp_it.test_task.dto.UserResponse;
import com.bootcamp_it.test_task.entities.User;
import com.bootcamp_it.test_task.mappers.UserMapper;
import com.bootcamp_it.test_task.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResponse create(UserRequest userRequest) {
        User user = userMapper.mapToUser(userRequest);
        User saveUser = userRepository.save(user);
        return userMapper.mapToUserResponse(saveUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .stream()
                .map(userMapper::mapToUserResponse)
                .toList();
    }
}
