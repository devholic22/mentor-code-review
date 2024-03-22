package study.codereview.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.codereview.order.exception.exceptions.OrderMoneyDivideException;
import study.codereview.order.exception.exceptions.OrderMoneyRangeException;
import study.codereview.order.exception.exceptions.OrderNotFoundException;

@RestControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(OrderMoneyDivideException.class)
    public ResponseEntity<String> handleOrderMoneyDivideException(final OrderMoneyDivideException exception) {
        return handleExceptionWithStatus(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderMoneyRangeException.class)
    public ResponseEntity<String> handleOrderMoneyRangeException(final OrderMoneyRangeException exception) {
        return handleExceptionWithStatus(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> handleOrderNotFoundException(final OrderNotFoundException exception) {
        return handleExceptionWithStatus(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<String> handleExceptionWithStatus(final Exception exception, final HttpStatus status) {
        return ResponseEntity.status(status)
                .body(exception.getMessage());
    }
}
