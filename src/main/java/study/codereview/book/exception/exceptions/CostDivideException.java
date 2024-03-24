package study.codereview.book.exception.exceptions;

public class CostDivideException extends RuntimeException {

    public CostDivideException() {
        super("가격은 나누어 떨어져야 합니다.");
    }
}
