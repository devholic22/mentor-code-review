package study.codereview.order.domain.vo;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import study.codereview.order.exception.exceptions.OrderMoneyDivideException;
import study.codereview.order.exception.exceptions.OrderMoneyRangeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class OrderMoneyTest {

    @Test
    void 입금할_돈을_넣는다() {
        // given
        int moneyValue = 10000;

        // when & then
        assertDoesNotThrow(() -> OrderMoney.from(moneyValue));
    }

    @Nested
    class 입금_돈_예외 {

        @Test
        void 입금할_금액이_음수면_예외가_발생한다() {
            // given
            int moneyValue = -12000;

            // when & then
            assertThatThrownBy(() -> OrderMoney.from(moneyValue))
                    .isInstanceOf(OrderMoneyRangeException.class);
        }

        @Test
        void 입금할_금액이_10으로_나누어_떨어지지_않으면_예외가_발생한다() {
            // given
            int moneyValue = 1234;

            // when & then
            assertThatThrownBy(() -> OrderMoney.from(moneyValue))
                    .isInstanceOf(OrderMoneyDivideException.class);
        }
    }
}
