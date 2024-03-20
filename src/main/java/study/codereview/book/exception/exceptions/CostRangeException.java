package study.codereview.book.exception.exceptions;

public class CostRangeException extends RuntimeException {

    public CostRangeException() {
        super("가격의 범위가 잘못되었습니다.");
    }
}
