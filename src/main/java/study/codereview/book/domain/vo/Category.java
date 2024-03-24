package study.codereview.book.domain.vo;

import study.codereview.book.exception.exceptions.CategoryNotFoundException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import static java.time.DayOfWeek.FRIDAY;

public enum Category {

    DEVELOP("개발") {

        private static final String TIME_ZONE = "Asia/Seoul";
        private static final double DISCOUNT_RATE = 0.15;

        @Override
        public int calculateAfterDiscount(final int cost) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of(TIME_ZONE));
            if (now.getDayOfWeek() == FRIDAY) {
                return (int) (cost * (1 - DISCOUNT_RATE));
            }
            return cost;
        }
    },
    CULTURE("교양") {

        private static final int DISCOUNT_PRICE = 1500;

        @Override
        public int calculateAfterDiscount(final int cost) {
            if (cost < DISCOUNT_PRICE) {
                return 0;
            }
            return cost - DISCOUNT_PRICE;
        }
    },
    MONEY("재테크") {

        @Override
        public int calculateAfterDiscount(final int cost) {
            return cost;
        }
    };

    private final String title;

    Category(final String title) {
        this.title = title;
    }

    public static Category findByTitle(final String title) {
        return Arrays.stream(Category.values())
                .filter(category -> category.isSame(title))
                .findAny()
                .orElseThrow(CategoryNotFoundException::new);
    }

    private boolean isSame(final String title) {
        return title.equals(this.title);
    }

    public abstract int calculateAfterDiscount(final int cost);

    public String getTitle() {
        return title;
    }
}
