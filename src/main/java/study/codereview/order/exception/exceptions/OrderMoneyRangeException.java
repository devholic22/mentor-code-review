package study.codereview.order.exception.exceptions;

public class OrderMoneyRangeException extends RuntimeException {

    public OrderMoneyRangeException() {
        super("주문 금액의 범위가 잘못되었습니다.");
    }
}
