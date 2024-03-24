package study.codereview.discount;

import study.codereview.book.domain.Book;

public interface DiscountPolicy {
    boolean isDiscountable(Book book);

    int discount(Book book);
}
