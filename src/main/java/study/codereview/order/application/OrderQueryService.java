package study.codereview.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.codereview.order.domain.OrderRepository;
import study.codereview.order.exception.exceptions.OrderNotFoundException;
import study.codereview.order.ui.infrastructure.dto.OrderCreateResponse;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderCreateResponse findCreatedOrder(final Long orderId) {
        return orderRepository.findCreatedOrderById(orderId)
                .orElseThrow(OrderNotFoundException::new);
    }
}
