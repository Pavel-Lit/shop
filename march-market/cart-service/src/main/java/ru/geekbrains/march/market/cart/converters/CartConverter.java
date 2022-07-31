package ru.geekbrains.march.market.cart.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.CartItemDto;
import ru.geekbrains.march.market.cart.utils.Cart;
import ru.geekbrains.march.market.cart.utils.CartItem;


import java.util.ArrayList;
import java.util.List;

@Component
public class CartConverter {



    public CartItemDto entityToDto(CartItem cartItem){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductId(cartItem.getProductId());
        cartItemDto.setProductTitle(cartItem.getProductTitle());
        cartItemDto.setPricePerProduct(cartItem.getPricePerProduct());
        cartItemDto.setPrice(cartItem.getPrice());
        cartItemDto.setQuantity(cartItem.getQuantity());
        return cartItemDto;


    }

    public List<CartItemDto> entityToListCart(List<CartItem> cart){
        List<CartItemDto> cartDtoList = new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            cartDtoList.add(entityToDto(cart.get(i)));
        }
        return cartDtoList;
    }

    public CartDto getCartDto(Cart cart){
        List<CartItemDto> list = entityToListCart(cart.getItems());
        CartDto cartDto = new CartDto();
        cartDto.setTotalPrice(cart.getTotalPrice());
        cartDto.setItems(list);
        return cartDto;

    }
}
