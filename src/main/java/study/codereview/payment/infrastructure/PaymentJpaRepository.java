package study.codereview.payment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import study.codereview.payment.domain.Payment;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {

    Payment save(Payment payment);
}
