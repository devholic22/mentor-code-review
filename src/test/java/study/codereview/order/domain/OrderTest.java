package study.codereview.order.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import study.codereview.order.exception.exceptions.OrderMoneyDivideException;
import study.codereview.order.exception.exceptions.OrderMoneyRangeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class OrderTest {

    @Test
    void 정상_생성() {
        // given
        Long bookId = 1L;
        int orderMoneyValue = 10000;

        // when & then
        assertDoesNotThrow(() -> Order.createDefault(bookId, orderMoneyValue));
    }

    @Test
    void 입금액이_음수면_예외_발생() {
        // given
        Long bookId = 1L;
        int orderMoneyValue = -12000;

        // when & then
        assertThatThrownBy(() -> Order.createDefault(bookId, orderMoneyValue))
                .isInstanceOf(OrderMoneyRangeException.class);
    }

    @Test
    void 입금액이_10으로_나누어_떨어지지_않으면_예외_발생() {
        // given
        Long bookId = 1L;
        int orderMoneyValue = 1234;

        // when & then
        assertThatThrownBy(() -> Order.createDefault(bookId, orderMoneyValue))
                .isInstanceOf(OrderMoneyDivideException.class);
    }
}
