package ru.geekbrains.march.market.core.tests;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.march.market.api.CartDto;
import ru.geekbrains.march.market.api.CartItemDto;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.march.market.core.converters.OrderConverter;
import ru.geekbrains.march.market.core.entities.Product;
import ru.geekbrains.march.market.core.integrations.CartServiceIntegration;
import ru.geekbrains.march.market.core.repositories.OrderRepository;
import ru.geekbrains.march.market.core.services.OrderService;
import ru.geekbrains.march.market.core.services.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private CartServiceIntegration cartServiceIntegration;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private ProductService productService;

    @Test
    public void createOrderTest(){
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Хлеб");
        CartItemDto cartItemDto = new CartItemDto(1L,BigDecimal.valueOf(64), 2, "Хлеб", BigDecimal.valueOf(32));
        ArrayList<CartItemDto> cartItemDtos = new ArrayList<>();
        cartItemDtos.add(cartItemDto);
        CartDto cartDto = new CartDto();
        cartDto.setItems(cartItemDtos);
        cartDto.setTotalPrice(BigDecimal.valueOf(64));
        Mockito.doReturn(cartDto).when(cartServiceIntegration).getCurrentCart("bob");
        Mockito.doReturn(product).when(productService).findById(1L);
        orderService.createOrder("bob", "Test", "9999999");
        Mockito.verify(orderRepository, Mockito.times(1)).save(ArgumentMatchers.any());


    }


}
