package study.codereview.order.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import study.codereview.order.domain.Order;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {

    Order save(Order order);
    boolean existsById(Long orderId);
}
