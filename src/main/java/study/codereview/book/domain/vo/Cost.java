package study.codereview.book.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.codereview.book.domain.exception.exceptions.CostDivideException;
import study.codereview.book.domain.exception.exceptions.CostRangeException;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Cost {

    private static final int MIN_VALUE = 0;
    private static final int REQUIRE_DIVIDE_ZERO = 10;

    private int cost;

    public Cost(int cost) {
        this.cost = cost;
    }

    public static Cost from(final int cost) {
        validateCostValue(cost);

        return new Cost(cost);
    }

    private static void validateCostValue(final int cost) {
        validateCostRange(cost);
        validateDivideZero(cost);
    }

    private static void validateCostRange(final int cost) {
        if (cost < MIN_VALUE) {
            throw new CostRangeException();
        }
    }

    private static void validateDivideZero(final int cost) {
        if (cost % REQUIRE_DIVIDE_ZERO != 0) {
            throw new CostDivideException();
        }
    }

    public Cost getCostAfterDiscountWithCategory(final Category category) {
        return Cost.from(category.calculateAfterDiscount(cost));
    }
}
