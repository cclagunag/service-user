package com.users.usermanagement.application.port.in;

import com.users.usermanagement.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {

    User createUser(User user);

    Optional<User> getUserById(UUID id);

    List<User> getAllUsers();

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);

}
