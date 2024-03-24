package study.codereview.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.codereview.payment.exception.exceptions.PaymentTypeNotFoundException;

@RestControllerAdvice
public class PaymentExceptionHandler {

    @ExceptionHandler(PaymentTypeNotFoundException.class)
    public ResponseEntity<String> handlePaymentNotFoundException(final PaymentTypeNotFoundException exception) {
        return handleExceptionWithStatus(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> handleExceptionWithStatus(final Exception exception, final HttpStatus status) {
        return ResponseEntity.status(status)
                .body(exception.getMessage());
    }
}
