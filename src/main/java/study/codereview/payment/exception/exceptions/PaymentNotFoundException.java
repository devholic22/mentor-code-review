package study.codereview.payment.exception.exceptions;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException() {
        super("등록되지 않은 결제 방법입니다.");
    }
}
