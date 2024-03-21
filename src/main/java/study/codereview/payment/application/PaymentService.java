package study.codereview.payment.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.codereview.order.domain.Order;
import study.codereview.order.domain.OrderRepository;
import study.codereview.order.exception.exceptions.OrderNotFoundException;
import study.codereview.payment.domain.Payment;
import study.codereview.payment.domain.PaymentRepository;

@RequiredArgsConstructor
@Transactional
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public void createPayment(final Long orderId, final String paymentTypeName) {
        Order order = findOrderById(orderId);
        Payment payment = Payment.createDefault(orderId, paymentTypeName);

        paymentRepository.save(payment);
    }

    private Order findOrderById(final Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new);
    }
}
