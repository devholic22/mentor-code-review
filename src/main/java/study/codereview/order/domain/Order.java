package study.codereview.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.codereview.global.domain.BaseEntity;
import study.codereview.order.domain.vo.OrderMoney;

@Getter
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

    @Column(nullable = false)
    private Integer bookCost;

    @Column(nullable = false)
    private Integer discount;

    @Column(nullable = false)
    private Integer orderPrice;

    private Order(final Long bookId, final int bookCost, final int discount, final OrderMoney orderMoney) {
        this.bookId = bookId;
        this.bookCost = bookCost;
        this.discount = discount;
        this.orderMoney = orderMoney;
        this.orderPrice = bookCost - discount;
    }

    public static Order createDefault(final Long bookId, final int bookCost, final int discount, final int orderMoneyValue) {
        OrderMoney orderMoney = OrderMoney.from(orderMoneyValue);
        return new Order(bookId, bookCost, discount, orderMoney);
    }

    public int getOrderMoney() {
        return orderMoney.getMoney();
    }
}
