package study.codereview.order.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderCreateRequest(
        @NotEmpty(message = "결제 방식이 작성되어야 합니다.")
        String paymentType,

        @NotNull(message = "구매할 책의 ID가 작성되어야 합니다.")
        Long bookId,

        @NotNull(message = "입금 금액이 작성되어야 합니다.")
        Integer orderMoney
) {
}
