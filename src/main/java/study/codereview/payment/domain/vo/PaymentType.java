package study.codereview.payment.domain.vo;

import study.codereview.payment.exception.exceptions.PaymentTypeNotFoundException;

import java.util.Arrays;

public enum PaymentType {

    CARD,
    CASH;

    public static PaymentType findByName(final String name) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.isSame(name))
                .findAny()
                .orElseThrow(PaymentTypeNotFoundException::new);
    }

    private boolean isSame(final String name) {
        return name.equals(this.name());
    }
}
