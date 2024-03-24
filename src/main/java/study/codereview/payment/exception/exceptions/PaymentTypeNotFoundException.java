package study.codereview.payment.exception.exceptions;

public class PaymentTypeNotFoundException extends RuntimeException {

    public PaymentTypeNotFoundException() {
        super("등록되지 않은 결제 방법입니다.");
    }
}
