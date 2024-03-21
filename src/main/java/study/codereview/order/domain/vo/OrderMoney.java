package study.codereview.order.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.codereview.order.exception.exceptions.OrderMoneyDivideException;
import study.codereview.order.exception.exceptions.OrderMoneyRangeException;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class OrderMoney {

    private static final int MIN_VALUE = 0;
    private static final int REQUIRE_DIVIDE_ZERO = 10;

    private int money;

    private OrderMoney(final int money) {
        this.money = money;
    }

    public static OrderMoney from(final int money) {
        validateOrderMoneyValue(money);
        return new OrderMoney(money);
    }

    private static void validateOrderMoneyValue(final int money) {
        validateOrderMoneyRange(money);
        validateDivideZero(money);
    }

    private static void validateOrderMoneyRange(final int money) {
        if (money < MIN_VALUE) {
            throw new OrderMoneyRangeException();
        }
    }

    private static void validateDivideZero(final int money) {
        if (money % REQUIRE_DIVIDE_ZERO != 0) {
            throw new OrderMoneyDivideException();
        }
    }
}
