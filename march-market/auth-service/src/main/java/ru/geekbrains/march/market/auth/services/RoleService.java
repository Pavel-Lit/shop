package ru.geekbrains.march.market.auth.services;

import lombok.RequiredArgsConstructor;
import ru.geekbrains.march.market.auth.entities.Role;
import ru.geekbrains.march.market.auth.repositories.RoleRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}

