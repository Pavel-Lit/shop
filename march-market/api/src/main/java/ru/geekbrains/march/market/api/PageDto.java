package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
@Schema(description = "Модель для пагинации")
public class PageDto {
    @Schema(description = "Списко элементов приходящих при запросе", required = true, example = "Хлеб, Молоко")
    private List<ProductDto> content;
    @Schema(description = "Колличество страниц", required = true, example = "4")
    private int totalPages;
    @Schema(description = "Текущая страница", required = true, example = "2")
    private int number;

    public List<ProductDto> getContent() {
        return content;
    }

    public void setContent(List<ProductDto> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PageDto() {
    }

    public PageDto(List<ProductDto> productDtoList, int totalPages, int currentPage) {
        this.content = productDtoList;
        this.totalPages = totalPages;
        this.number = currentPage;
    }
}
