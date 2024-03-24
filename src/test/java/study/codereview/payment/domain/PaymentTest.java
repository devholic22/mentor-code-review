package study.codereview.payment.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import study.codereview.payment.exception.exceptions.PaymentTypeNotFoundException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class PaymentTest {

    @Test
    void 정상_생성() {
        // given
        Long orderId = 1L;
        String paymentType = "CARD";

        // when & then
        assertDoesNotThrow(() -> Payment.createDefault(orderId, paymentType));
    }
    
    @Test
    void 결제_방식이_올바르지_않으면_예외_발생() {
        // given
        Long orderId = 1L;
        String paymentType = "hello";

        // when & then
        assertThatThrownBy(() -> Payment.createDefault(orderId, paymentType))
                .isInstanceOf(PaymentTypeNotFoundException.class);
    }
}
