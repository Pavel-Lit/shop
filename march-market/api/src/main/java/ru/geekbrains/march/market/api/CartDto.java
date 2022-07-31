package ru.geekbrains.march.market.api;



import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;


@Schema(description = "Модель корзины")
public class CartDto {

    @Schema(description = "Стоимость корзины всей корзины", required = true, example = "100")
    private BigDecimal totalPrice;
    @Schema(description = "Список заказанных позиций", required = true, example = "Молоко, хлеб")
    private List<CartItemDto> items;

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


    public CartDto(BigDecimal totalPrice, List<CartItemDto> items) {
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public CartDto() {
    }
}
