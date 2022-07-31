package ru.geekbrains.march.market.auth.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.march.market.api.RegistrUserDto;
import ru.geekbrains.march.market.auth.converters.RegistrUserConverter;
import ru.geekbrains.march.market.auth.exceptions.AppError;
import ru.geekbrains.march.market.auth.services.UserService;

@RestController
@RequiredArgsConstructor
@Tag(name = "Регистрация", description = "Методы для работы с регистрацией")
public class RegistrationController {
    private final UserService userService;
    private final RegistrUserConverter registrUserConverter;

    @Operation(summary = "Регистрация нового пользователя",
            responses = {
                    @ApiResponse(description = "Новый пользователь зарегистрирован", responseCode = "201"),
                    @ApiResponse(description = "Пароли не совпадоют", responseCode = "409",
                            content = @Content(schema = @Schema(implementation = AppError.class))),
                    @ApiResponse(description = "Пользователь с таким именем уже существует", responseCode = "409",
                            content = @Content(schema = @Schema(implementation = AppError.class)))
            })
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrationNewUser(@RequestBody RegistrUserDto registrUserDto) {
        if (!registrUserDto.getPassword().equals(registrUserDto.getConfirmPassword()))
            throw new IllegalStateException("Пароли не совпадоют");
        if (userService.findByUsername(registrUserDto.getUsername()).isPresent()) {
            throw new IllegalStateException("Пользователь с таким именем уже существует");
        }
        userService.saveNewUser(registrUserConverter.dtoToUserEntity(registrUserDto));
    }
}
