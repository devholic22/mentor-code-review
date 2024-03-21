package study.codereview.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.codereview.book.domain.BookRepository;
import study.codereview.book.exception.exceptions.BookNotFoundException;
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
    private final BookRepository bookRepository;

    public Order createOrder(final OrderCreateRequest request) {
        validateIsBookExist(request.bookId());

        Order savedOrder = createOrderByCreateRequest(request);
        Events.raise(new OrderCreatedEvent(request.bookId(), request.paymentType()));

        return savedOrder;
    }

    private void validateIsBookExist(final Long bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException();
        }
    }

    private Order createOrderByCreateRequest(final OrderCreateRequest request) {
        Order order = Order.createDefault(request.bookId(), request.orderMoney());
        return orderRepository.save(order);
    }
}
