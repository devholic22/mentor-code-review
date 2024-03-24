package study.codereview.order.domain;

import study.codereview.order.ui.infrastructure.dto.OrderCreateResponse;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);
    boolean existsById(Long orderId);
    Optional<OrderCreateResponse> findCreatedOrderById(Long orderId);
}
