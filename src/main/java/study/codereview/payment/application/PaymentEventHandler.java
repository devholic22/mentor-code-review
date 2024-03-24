package study.codereview.payment.application;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import study.codereview.order.application.event.OrderCreatedEvent;

@RequiredArgsConstructor
@Component
public class PaymentEventHandler {

    private final PaymentService paymentService;

    // TODO: payment가 event로 반드시 처리되어야하나?
    // 주문과 페이먼트는 같은 라이프사이클로 처리하면 쉽게해결ㅇ할 수있다.
    // 물론, 나중에 Event로 처리해야하는 이유가 있을 수 있지만, 현재로서는 그럴 필요가 없다.
    // CASH CARD << 다형성 적용해서 처리해보기
    @EventListener
    public void createPaymentHistory(final OrderCreatedEvent event) {
        paymentService.createPayment(event.orderId(), event.paymentTypeName());
    }
}
