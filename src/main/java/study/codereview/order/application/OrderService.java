package study.codereview.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.codereview.book.domain.Book;
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

    public Long createOrder(final OrderCreateRequest request) {
        Book book = findBookById(request.bookId());

        Order savedOrder = createOrder(request, book);
        Events.raise(new OrderCreatedEvent(savedOrder.getId(), request.paymentType()));

        return savedOrder.getId();
    }

    private Book findBookById(final Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);
    }

    private Order createOrder(final OrderCreateRequest request, final Book book) {
        Order order = Order.createDefault(book.getId(), book.getCostValue(), book.getDiscount(), request.orderMoney());
        return orderRepository.save(order);
    }
}
