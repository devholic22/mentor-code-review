package study.codereview.book.vo;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import study.codereview.book.domain.vo.Cost;
import study.codereview.book.exception.exceptions.CostDivideException;
import study.codereview.book.exception.exceptions.CostRangeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CostTest {

    @Test
    void 금액을_생성한다() {
        // given
        int costValue = 10000;

        // when & then
        assertDoesNotThrow(() -> Cost.from(costValue));
    }

    @Test
    void 금액을_수정한다() {
        // given
        int costValue = 10000;
        int updatedCostValue = 12000;
        Cost cost = Cost.from(costValue);

        // when
        Cost afterCost = cost.updateCost(updatedCostValue);

        // then
        assertThat(afterCost.getCost()).isEqualTo(updatedCostValue);
    }

    @Nested
    class 금액_예외 {

        @Test
        void 생성_시_금액이_음수면_예외가_발생한다() {
            // given
            int costValue = -1200;

            // when & then
            assertThatThrownBy(() -> Cost.from(costValue))
                    .isInstanceOf(CostRangeException.class);
        }

        @Test
        void 생성_시_금액이_10으로_나누어_떨어지지_않으면_예외가_발생한다() {
            // given
            int costValue = 1234;

            // when & then
            assertThatThrownBy(() -> Cost.from(costValue))
                    .isInstanceOf(CostDivideException.class);
        }

        @Test
        void 수정_시_금액이_음수면_예외가_발생한다() {
            // given
            int costValue = 10000;
            int updatedCostValue = -1200;
            Cost cost = Cost.from(costValue);

            // when & then
            assertThatThrownBy(() -> cost.updateCost(updatedCostValue))
                    .isInstanceOf(CostRangeException.class);
        }

        @Test
        void 수정_시_금액이_10으로_나누어_떨어지지_않으면_예외가_발생한다() {
            // given
            int costValue = 10000;
            int updatedCostValue = 1234;
            Cost cost = Cost.from(costValue);

            // when & then
            assertThatThrownBy(() -> cost.updateCost(updatedCostValue))
                    .isInstanceOf(CostDivideException.class);
        }
    }
}
