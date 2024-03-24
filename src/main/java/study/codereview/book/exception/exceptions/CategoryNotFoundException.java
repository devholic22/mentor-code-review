package study.codereview.book.exception.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("등록되지 않은 카테고리 입니다.");
    }
}
