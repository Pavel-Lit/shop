package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель для регистрации пользователя")
public class RegistrUserDto {
    @Schema(description = "Имя пользователя", required = true, maxLength = 36, example = "Bob")
    private String username;
    @Schema(description = "Пароль пользователя", required = true, maxLength = 80, example = "$2a$12$PJO.nk28tJO5cGp3YphGUen7bXun.LFeTyjr2GtmcauWZw8/Kssx.")
    private String password;
    @Schema(description = "Подверждение пароля пользователя", required = true, maxLength = 80, example = "$2a$12$PJO.nk28tJO5cGp3YphGUen7bXun.LFeTyjr2GtmcauWZw8/Kssx.")
    private String confirmPassword;
    @Schema(description = "Электронная почта пользователя", required = true, maxLength = 50, example = "1@1.ru")
    private String email;

    public RegistrUserDto(String username, String password, String confirmPassword, String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegistrUserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
