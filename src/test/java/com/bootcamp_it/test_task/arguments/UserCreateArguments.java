package com.bootcamp_it.test_task.arguments;

import com.bootcamp_it.test_task.dto.UserRequest;
import com.bootcamp_it.test_task.dto.UserResponse;
import com.bootcamp_it.test_task.entities.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.bootcamp_it.test_task.entities.Role.ADMINISTRATOR;

public class UserCreateArguments implements ArgumentsProvider {

    public static final User USER = User.builder()
            .id(12L)
            .surname("Betska")
            .name("Dmitry")
            .patronymic("Miecheslavovich")
            .email("d.betska@gmail.com")
            .role(ADMINISTRATOR)
            .build();

    public static final UserRequest USER_REQUEST = UserRequest.builder()
            .surname("Betska")
            .name("Dmitry")
            .patronymic("Miecheslavovich")
            .email("d.betska@gmail.com")
            .role(ADMINISTRATOR)
            .build();

    public static final UserResponse USER_RESPONSE = UserResponse.builder()
            .id(12L)
            .surname("Betska")
            .name("Dmitry")
            .patronymic("Miecheslavovich")
            .email("d.betska@gmail.com")
            .role(ADMINISTRATOR)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(USER_REQUEST, USER, USER_RESPONSE)
        );
    }
}
