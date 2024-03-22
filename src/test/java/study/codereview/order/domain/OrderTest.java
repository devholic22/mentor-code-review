package study.codereview.order.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import study.codereview.book.domain.Book;
import study.codereview.order.exception.exceptions.OrderMoneyDivideException;
import study.codereview.order.exception.exceptions.OrderMoneyRangeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static study.codereview.book.fixture.BookFixture.개발_책_일반;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class OrderTest {

    @Test
    void 정상_생성() {
        // given
        Book book = 개발_책_일반();
        int orderMoneyValue = 10000;

        // when & then
        assertDoesNotThrow(() -> Order.createDefault(
                book.getId(),
                book.getCostValue(),
                book.getDiscount(),
                orderMoneyValue)
        );
    }

    @Test
    void 입금액이_음수면_예외_발생() {
        // given
        Book book = 개발_책_일반();
        int orderMoneyValue = -12000;

        // when & then
        assertThatThrownBy(() -> Order.createDefault(book.getId(), book.getCostValue(), book.getDiscount(), orderMoneyValue))
                .isInstanceOf(OrderMoneyRangeException.class);
    }

    @Test
    void 입금액이_10으로_나누어_떨어지지_않으면_예외_발생() {
        // given
        Book book = 개발_책_일반();
        int orderMoneyValue = 1234;

        // when & then
        assertThatThrownBy(() -> Order.createDefault(book.getId(), book.getCostValue(), book.getDiscount(), orderMoneyValue))
                .isInstanceOf(OrderMoneyDivideException.class);
    }
}
