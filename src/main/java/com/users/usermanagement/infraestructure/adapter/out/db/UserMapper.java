package com.users.usermanagement.infraestructure.adapter.out.db;

import com.users.usermanagement.domain.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserEntity toEntity(User user) {
        if( user == null) return null;
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public User toDomain(UserEntity entity) {
        if( entity == null) return null;
        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }
}
