package ru.geekbrains.march.market.cart.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.StringResponse;
import ru.geekbrains.march.market.cart.converters.CartConverter;
import ru.geekbrains.march.market.cart.services.CartService;
import ru.geekbrains.march.market.cart.utils.Cart;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Tag(name = "Корзины", description = "Методы оаботы с корзинами")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @Operation(summary = "Запрос на получение индефикатора корзины")
    @GetMapping("/generate_id")
    public StringResponse generateCartId() {
        return new StringResponse(UUID.randomUUID().toString());
    }

    @Operation(summary = "Получение списка товаров в корзине",
            responses = {
                    @ApiResponse(
                            description = "успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CartDto.class)))
            })
    @GetMapping("/{guestCartId}")
    public CartDto getCurrentCartDto(@RequestHeader(required = false) String username, @PathVariable String guestCartId) {
        String currentCartId = selectCartId(username, guestCartId);
        return cartConverter.getCartDto(cartService.getCurrentCart(currentCartId));
    }

    @Operation(summary = "Добавление товара в корзину",
            responses = {
                    @ApiResponse(description = "Корзина очищена", responseCode = "200")
            })
    @GetMapping("/{guestCartId}/add/{productId}")
    public void addProductToCart(@RequestHeader(required = false) String username, @PathVariable String guestCartId, @PathVariable Long productId) {
        String currentCartId = selectCartId(username, guestCartId);
        cartService.addToCart(currentCartId, productId);
    }

    @Operation(summary = "Удаление одного товара из корзины",
            responses = {
                    @ApiResponse(description = "Корзина очищена", responseCode = "200")
            })
    @GetMapping("/{guestCartId}/remove/{id}")
    public void removeOneProductFromCart(@RequestHeader(required = false) String username, @PathVariable String guestCartId, @PathVariable Long id) {
        String currentCartId = selectCartId(username, guestCartId);
        cartService.removeById(currentCartId, id);
    }

    @Operation(summary = "Удаление всех товаров из корзины",
            responses = {
                    @ApiResponse(description = "Корзина очищена", responseCode = "200")
            })
    @GetMapping("/{guestCartId}/clear")
    public void clearCart(@RequestHeader(required = false) String username, @PathVariable String guestCartId) {
        String currentCartId = selectCartId(username, guestCartId);
        cartService.clearCart(currentCartId);

    }

    @Operation(summary = "Объединение гостевой корзины и корзины зарегистрированного пользователя")
    @GetMapping("{guestCartId}/merge")
    public void mergeCarts(@RequestHeader String username, @PathVariable String guestCartId) {
        cartService.mergeCart(guestCartId, username);
    }


    private String selectCartId(String username, String guestCartId) {
        if (username != null) {
            return username;
        }
        return guestCartId;
    }


}
