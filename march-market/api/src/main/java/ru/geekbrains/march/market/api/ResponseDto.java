package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель простого ответа")
public class ResponseDto {
    @Schema(description = "Ответ", required = true, example = "Какое то сообщение")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ResponseDto(String response) {
        this.response = response;
    }

    public ResponseDto() {
    }
}
