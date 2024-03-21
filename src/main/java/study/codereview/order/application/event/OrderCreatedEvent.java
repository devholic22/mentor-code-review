package study.codereview.order.application.event;

public record OrderCreatedEvent(
        Long orderId,
        String paymentTypeName
) {
}
