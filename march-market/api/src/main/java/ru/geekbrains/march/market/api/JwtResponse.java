package ru.geekbrains.march.market.api;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ при регистрации")
public class JwtResponse {
    @Schema(description = "Токен пользователя", required = true, example = "iiuVIVHVIGq3r4139huwehf")
    private String token;

    public JwtResponse() {

    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
