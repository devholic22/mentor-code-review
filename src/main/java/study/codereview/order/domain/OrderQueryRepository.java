package study.codereview.order.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.codereview.order.infrastructure.dto.OrderCreateResponse;

import java.util.Optional;
import static com.querydsl.core.types.Projections.constructor;
import static study.codereview.book.domain.QBook.book;
import static study.codereview.order.domain.QOrder.order;
import static study.codereview.payment.domain.QPayment.payment;

@RequiredArgsConstructor
@Repository
public class OrderQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Optional<OrderCreateResponse> findCreatedOrderById(final Long orderId) {
        OrderCreateResponse response = queryFactory.select(constructor(OrderCreateResponse.class,
                        order.createdAt,
                        order.orderMoney.money,
                        book.cost.cost,
                        order.discount,
                        order.orderMoney.money.subtract(book.cost.cost).add(order.discount))
                ).from(order)
                .join(payment)
                .on(payment.orderId.eq(order.id))
                .join(book)
                .on(order.bookId.eq(book.id))
                .where(order.id.eq(orderId))
                .fetchOne();

        return Optional.ofNullable(response);
    }
}
