package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Модель заказа")
public class OrderDto {
    @Schema(description = "ID заказа", required = true, example = "2")
    private Long id;
    @Schema(description = "Список покупок", required = true)
    private List<OrderItemDto> list;
    @Schema(description = "Стоимость всего заказа", required = true, example = "1000")
    private BigDecimal totalPrice;
    @Schema(description = "Адрес доставки", required = true, maxLength = 255, example = "Москва, ул. Ленина, д.1")
    private String address;
    @Schema(description = "Номер телефона", required = true, maxLength = 20, example = "89990001122")
    private String phoneNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public OrderDto() {
    }

    public OrderDto(Long id, List<OrderItemDto> list, BigDecimal totalPrice, String address, String phoneNumber) {
        this.id = id;
        this.list = list;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItemDto> getList() {
        return list;
    }

    public void setList(List<OrderItemDto> list) {
        this.list = list;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
