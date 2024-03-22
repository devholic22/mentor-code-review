package study.codereview.order.infrastructure.dto;

import java.time.LocalDateTime;

public record OrderCreateResponse(
        LocalDateTime createdAt,
        Integer orderMoney,
        Integer bookCost,
        Integer remainMoney
) {
}
