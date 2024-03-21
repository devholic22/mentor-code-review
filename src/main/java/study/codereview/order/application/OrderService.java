package study.codereview.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.codereview.global.event.Events;
import study.codereview.order.application.dto.OrderCreateRequest;
import study.codereview.order.application.event.OrderCreatedEvent;
import study.codereview.order.domain.Order;
import study.codereview.order.domain.OrderRepository;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(final OrderCreateRequest request) {
        Order order = Order.createDefault(request.bookId(), request.orderMoney());
        Order savedOrder = orderRepository.save(order);
        Events.raise(new OrderCreatedEvent(request.bookId(), request.paymentType()));

        return savedOrder;
    }
}
