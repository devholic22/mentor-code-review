package study.codereview.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.codereview.order.domain.Order;
import study.codereview.order.domain.OrderQueryRepository;
import study.codereview.order.domain.OrderRepository;
import study.codereview.order.infrastructure.dto.OrderCreateResponse;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderQueryRepository orderQueryRepository;

    @Override
    public Order save(final Order order) {
        return orderJpaRepository.save(order);
    }

    @Override
    public boolean existsById(final Long orderId) {
        return orderJpaRepository.existsById(orderId);
    }

    @Override
    public Optional<OrderCreateResponse> findCreatedOrderById(final Long orderId) {
        return orderQueryRepository.findCreatedOrderById(orderId);
    }
}
