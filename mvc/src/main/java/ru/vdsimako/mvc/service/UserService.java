package ru.vdsimako.mvc.service;

import org.springframework.stereotype.Service;
import ru.vdsimako.mvc.model.dto.CreateUserDto;
import ru.vdsimako.mvc.model.dto.UpdateUserDto;
import ru.vdsimako.mvc.model.dto.UserDto;
import ru.vdsimako.mvc.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        UserDto userDto;

        if (createUserDto.getUsername().equals("test")) {
            userDto = UserDto.builder()
                    .id(1L)
                    .username(createUserDto.getUsername().concat("user"))
                    .dateOfBirth(createUserDto.getDateOfBirth())
                    .build();
        } else {
            userDto = UserDto.builder()
                    .id(1L)
                    .username(createUserDto.getUsername())
                    .dateOfBirth(createUserDto.getDateOfBirth())
                    .build();
        }

        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, UpdateUserDto updateUserDto) {
        UserDto userDto;
        if (userRepository.existById(id))  {
            userDto = UserDto.builder().build();
            if (!userDto.getUsername().startsWith("test")) {
                userRepository.save(userDto);
            } else {
                throw new RuntimeException("user is test");
            }
        } else {
            throw new RuntimeException("user not found");
        }
        return userDto;
    }
}
