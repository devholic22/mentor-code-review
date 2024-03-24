package study.codereview.order.exception.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super("관련 주문을 찾을 수 없습니다.");
    }
}
