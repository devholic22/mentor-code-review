package study.codereview.order.domain;

public interface OrderRepository {

    Order save(Order order);
    boolean existsById(Long orderId);
}
