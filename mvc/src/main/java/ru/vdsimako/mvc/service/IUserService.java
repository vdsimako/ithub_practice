package ru.vdsimako.mvc.service;


import ru.vdsimako.mvc.model.dto.CreateUserDto;
import ru.vdsimako.mvc.model.dto.UpdateUserDto;
import ru.vdsimako.mvc.model.dto.UserDto;

public interface IUserService {
    UserDto createUser(CreateUserDto createUserDto);

    UserDto updateUser(Long id, UpdateUserDto updateUserDto);
}
