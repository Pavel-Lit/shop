package ru.geekbrains.march.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.api.CartItemDto;
import ru.geekbrains.march.market.core.entities.OrderItem;
import ru.geekbrains.march.market.core.integrations.CartServiceIntegration;
import ru.geekbrains.march.market.core.repositories.OrderItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsService  {

    private final OrderItemRepository orderItemRepository;


    public void save(OrderItem orderItem){
        orderItemRepository.save(orderItem);
    }





}
