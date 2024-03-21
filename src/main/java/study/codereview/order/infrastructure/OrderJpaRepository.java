package study.codereview.order.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import study.codereview.order.domain.Order;

import java.util.Optional;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {

    Order save(Order order);
    Optional<Order> findById(Long orderId);
}
