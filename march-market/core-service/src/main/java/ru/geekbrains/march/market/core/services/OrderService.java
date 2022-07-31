package ru.geekbrains.march.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.CartItemDto;
import ru.geekbrains.march.market.api.OrderDto;
import ru.geekbrains.march.market.core.converters.OrderConverter;
import ru.geekbrains.march.market.core.entities.Order;
import ru.geekbrains.march.market.core.entities.OrderItem;
import ru.geekbrains.march.market.core.entities.Product;
import ru.geekbrains.march.market.core.integrations.CartServiceIntegration;
import ru.geekbrains.march.market.core.repositories.OrderRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartServiceIntegration cartServiceIntegration;
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderConverter orderConverter;

    @Transactional
    public void createOrder(String username, String address, String phoneNumber) {

            CartDto cartDto = cartServiceIntegration.getCurrentCart(username);
            if (cartDto.getItems().isEmpty()) {
                throw new IllegalStateException("Нельзя оформить заказ для пустой корзины");
            }
                Order order = new Order();
                order.setTotalPrice(cartDto.getTotalPrice());
                order.setUsername(username);
                order.setItems(parseCartItems(cartDto.getItems(), order));
                order.setAddress(address);
                order.setPhoneNumber(phoneNumber);
                orderRepository.save(order);
                cartServiceIntegration.clearCart(username);


    }

    public List<OrderItem> parseCartItems(List<CartItemDto> list, Order order) {

        List<OrderItem> listOrderItems = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            OrderItem orderItem = new OrderItem();
            Product product = productService.findById(list.get(i).getProductId());
            orderItem.setPrice(list.get(i).getPrice());
            orderItem.setProduct(product);
            orderItem.setPricePerProduct(list.get(i).getPricePerProduct());
            orderItem.setQuantity(list.get(i).getQuantity());
            orderItem.setOrder(order);
            listOrderItems.add(orderItem);
        }
    return listOrderItems;

    }

    public List<OrderDto> getUserOrders(String username){
        return orderRepository.findAllByUsername(username).stream().map(orderConverter::entityToDto).collect(Collectors.toList());
    }
}






