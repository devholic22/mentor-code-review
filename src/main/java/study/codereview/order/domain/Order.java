package study.codereview.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import study.codereview.global.domain.BaseEntity;
import study.codereview.order.domain.vo.OrderMoney;

@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Embedded
    private OrderMoney orderMoney;

    @Column(nullable = false)
    private Long bookId;

    private Order(final Long bookId, final OrderMoney orderMoney) {
        this.bookId = bookId;
        this.orderMoney = orderMoney;
    }

    public static Order createDefault(final Long bookId, final int orderMoneyValue) {
        OrderMoney orderMoney = OrderMoney.from(orderMoneyValue);
        return new Order(bookId, orderMoney);
    }

    public int getOrderMoney() {
        return orderMoney.getMoney();
    }

    public Long getBookId() {
        return bookId;
    }
}
