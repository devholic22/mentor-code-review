package study.codereview.discount;

import study.codereview.book.domain.Book;

public class TimeDiscountPolicy(discountDay DayofWeek, systemTime) implements DiscountPolicy{
    boolean isDiscountable(Book book) {
        return false;
    }

    int discount(Book book) {
        return 0;
    }
}
