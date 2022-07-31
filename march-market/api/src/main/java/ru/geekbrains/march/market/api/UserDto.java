package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель пользователя")
public class UserDto {
    @Schema(description = "ID пользователя", required = true, example = "1")
    private Long id;
    @Schema(description = "Имя пользователя", required = true, maxLength = 36, example = "David")
    private String name;
    @Schema(description = "Электронная почта", required = true, maxLength = 50, example = "2@2.ru")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDto() {
    }
}
