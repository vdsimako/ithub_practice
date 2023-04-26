package ru.vdsimako.mvc.controller;


import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ru.vdsimako.mvc.model.dto.CreateUserDto;
import ru.vdsimako.mvc.model.dto.UpdateUserDto;
import ru.vdsimako.mvc.model.dto.UserDto;
import ru.vdsimako.mvc.service.IUserService;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        log.info("Get request for create user: {}", createUserDto);

        UserDto userDto = service.createUser(createUserDto);

        log.info("Return response for create user: {}", userDto);

        return userDto;
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,
                              @Valid @RequestBody UpdateUserDto updateUserDto) {
        log.info("Get request for create user: {}", updateUserDto);

        UserDto userDto = service.updateUser(id, updateUserDto);

        log.info("Return response for create user: {}", userDto);

        return userDto;
    }

    @DeleteMapping("/{id}")
    public UserDto deleteUser(@PathVariable  Long id) {
        return null;
    }
}
