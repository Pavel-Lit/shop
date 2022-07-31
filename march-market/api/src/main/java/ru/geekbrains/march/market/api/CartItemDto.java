package ru.geekbrains.march.market.api;



import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Модель элемнат корзины")
public class CartItemDto {
    @Schema(description = "ID продукта", required = true, example = "1")
    private Long productId;
    @Schema(description = "Стоимость всех продуктов", required = true, example = "100")
    private BigDecimal price;
    @Schema(description = "Колличество продуктов", required = true, example = "2")
    private int quantity;
    @Schema(description = "Название продукта", required = true, example = "Хлеб")
    private String productTitle;
    @Schema(description = "Стоимость одного продукта", required = true, example = "22")
    private  BigDecimal pricePerProduct;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public BigDecimal getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(BigDecimal pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public CartItemDto() {
    }

    public CartItemDto(Long productId, BigDecimal price, int quantity, String productTitle, BigDecimal pricePerProduct) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.productTitle = productTitle;
        this.pricePerProduct = pricePerProduct;
    }
}
