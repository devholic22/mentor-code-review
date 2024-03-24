package study.codereview.order.exception.exceptions;

public class OrderMoneyDivideException extends RuntimeException {

    public OrderMoneyDivideException() {
        super("주문 금액은 나누어 떨어져야 합니다.");
    }
}
