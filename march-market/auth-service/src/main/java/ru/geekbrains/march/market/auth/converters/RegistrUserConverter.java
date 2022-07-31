package ru.geekbrains.march.market.auth.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.RegistrUserDto;
import ru.geekbrains.march.market.auth.entities.Role;
import ru.geekbrains.march.market.auth.entities.User;
import ru.geekbrains.march.market.auth.services.RoleService;

import java.util.ArrayList;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegistrUserConverter {
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public User dtoToUserEntity(RegistrUserDto registrUserDto){
        List<Role> list = new ArrayList<>();
        list.add(roleService.getUserRole());
        User user = new User();
        user.setUsername(registrUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrUserDto.getPassword()));
        user.setEmail(registrUserDto.getEmail());
        user.setRoles(list);
        return user;
    }
}
