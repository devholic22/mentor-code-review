package study.codereview.book.exception.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("관련 책을 찾을 수 없습니다.");
    }
}
