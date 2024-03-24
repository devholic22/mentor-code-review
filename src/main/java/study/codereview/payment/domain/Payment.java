package study.codereview.payment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import study.codereview.payment.domain.vo.PaymentType;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    private Payment(final Long orderId, final PaymentType paymentType) {
        this.orderId = orderId;
        this.paymentType = paymentType;
    }

    public static Payment createDefault(final Long orderId, final String paymentTypeName) {
        PaymentType paymentType = PaymentType.findByName(paymentTypeName);

        return new Payment(orderId, paymentType);
    }

    public String getPaymentTypeName() {
        return paymentType.name();
    }
}
