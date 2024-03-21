package study.codereview.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.codereview.order.domain.Order;
import study.codereview.order.domain.OrderRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order save(final Order order) {
        return orderJpaRepository.save(order);
    }

    @Override
    public Optional<Order> findById(final Long orderId) {
        return orderJpaRepository.findById(orderId);
    }
}
