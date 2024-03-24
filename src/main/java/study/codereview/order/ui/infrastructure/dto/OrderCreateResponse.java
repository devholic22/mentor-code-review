package study.codereview.order.ui.infrastructure.dto;

import study.codereview.payment.domain.vo.PaymentType;

import java.time.LocalDateTime;

public record OrderCreateResponse(
        LocalDateTime createdAt,
        PaymentType paymentType,
        Integer orderMoney,
        Integer bookCost,
        Integer discount,
        Integer remainMoney
) {
}
