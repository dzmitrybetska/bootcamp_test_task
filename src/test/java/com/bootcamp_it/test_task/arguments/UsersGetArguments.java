package com.bootcamp_it.test_task.arguments;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.stream.Stream;

import static com.bootcamp_it.test_task.arguments.UserCreateArguments.USER;
import static com.bootcamp_it.test_task.arguments.UserCreateArguments.USER_RESPONSE;

public class UsersGetArguments implements ArgumentsProvider {

    public static final Pageable pageable = PageRequest.of(0, 10, Sort.by("email"));

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(USER, USER_RESPONSE, pageable)
        );
    }
}
