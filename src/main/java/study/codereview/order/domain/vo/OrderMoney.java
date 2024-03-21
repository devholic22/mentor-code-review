package study.codereview.order.domain.vo;

import lombok.Getter;
import study.codereview.order.exception.exceptions.OrderMoneyDivideException;
import study.codereview.order.exception.exceptions.OrderMoneyRangeException;

@Getter
public class OrderMoney {

    private static final int MIN_VALUE = 0;
    private static final int REQUIRE_DIVIDE_ZERO = 10;

    private final int money;

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
