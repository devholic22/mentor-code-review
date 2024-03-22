package study.codereview.book.fixture;

import study.codereview.book.domain.Book;
import study.codereview.book.domain.vo.Category;
import study.codereview.book.domain.vo.Cost;

public class BookFixture {

    public static Book 개발_책_일반() {
        return Book.builder()
                .id(1L)
                .name("이펙티브 자바")
                .category(Category.DEVELOP)
                .cost(Cost.from(10000))
                .build();
    }
}
