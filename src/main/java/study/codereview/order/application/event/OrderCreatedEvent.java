package study.codereview.order.application.event;

public record OrderCreatedEvent(
        Long bookId,
        Integer orderMoneyValue,
        String paymentTypeName
) {
}
