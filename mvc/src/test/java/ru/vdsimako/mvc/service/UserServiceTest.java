package ru.vdsimako.mvc.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vdsimako.mvc.model.dto.CreateUserDto;
import ru.vdsimako.mvc.model.dto.UserDto;
import ru.vdsimako.mvc.provider.UserProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @InjectMocks
    private UserService service;

    @ParameterizedTest
    @MethodSource("ru.vdsimako.mvc.argument.UserServiceArg#getCreateUserDtoArgs")
    void createUser_whenValidUser_thenUser(CreateUserDto createUserDto,
                                           UserDto expectedUserDto) {
        UserDto actualUserDto = service.createUser(createUserDto);

        assertEquals(expectedUserDto, actualUserDto);
    }

}