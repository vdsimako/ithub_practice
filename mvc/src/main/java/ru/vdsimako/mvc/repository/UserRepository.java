package ru.vdsimako.mvc.repository;

import org.springframework.stereotype.Repository;
import ru.vdsimako.mvc.model.dto.UserDto;

import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<UserDto> findUserById(Long id);

    boolean existById(Long id);

    void save(UserDto userDto);
}
