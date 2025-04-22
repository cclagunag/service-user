package com.users.usermanagement.application.service;

import com.users.usermanagement.application.port.in.IUserService;
import com.users.usermanagement.domain.model.User;
import com.users.usermanagement.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UUID id, User user) {
        User model = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario con id: " + id + " NO existe"));

        model.setUsername(user.getUsername());

        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            model.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(model);

    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
