package study.codereview.book.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.codereview.book.domain.exception.exceptions.CategoryNotFoundException;
import study.codereview.book.domain.exception.exceptions.CostDivideException;
import study.codereview.book.domain.exception.exceptions.CostRangeException;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(final CategoryNotFoundException exception) {
        return handleExceptionWithStatus(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CostDivideException.class)
    public ResponseEntity<String> handleCostDivideException(final CostDivideException exception) {
        return handleExceptionWithStatus(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CostRangeException.class)
    public ResponseEntity<String> handleCostRangeException(final CostRangeException exception) {
        return handleExceptionWithStatus(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> handleExceptionWithStatus(final Exception exception, final HttpStatus status) {
        return ResponseEntity.status(status)
                .body(exception.getMessage());
    }
}
