package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
@Schema(description = "Модель элемнат заказа")
public class OrderItemDto {

    @Schema(description = "Нормер заказа", required = true, example = "2")
    private Long orderId;
    @Schema(description = "Наименование продукта", required = true, example = "Хлеб")
    private String productTitle;
    @Schema(description = "Колличество заказанных продуктов", required = true, example = "5")
    private int quantity;
    @Schema(description = "Стоимость одного продукта", required = true, example = "10")
    private BigDecimal pricePerProduct;
    @Schema(description = "Стоимость всего заказа", required = true, example = "1000")
    private BigDecimal totalPrice;

    public OrderItemDto(Long productId, String productTitle, int quantity, BigDecimal pricePerProduct, BigDecimal totalPrice) {
        this.orderId = productId;
        this.productTitle = productTitle;
        this.quantity = quantity;
        this.pricePerProduct = pricePerProduct;
        this.totalPrice = totalPrice;
    }

    public OrderItemDto() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(BigDecimal pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
