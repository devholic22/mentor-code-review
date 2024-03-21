package study.codereview.payment.application;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import study.codereview.order.application.event.OrderCreatedEvent;

@RequiredArgsConstructor
@Component
public class PaymentEventHandler {

    private final PaymentService paymentService;

    @EventListener
    public void createPaymentHistory(final OrderCreatedEvent event) {
        paymentService.createPayment(event.orderId(), event.paymentTypeName());
    }
}
