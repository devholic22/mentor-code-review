package study.codereview.book;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import study.codereview.book.domain.Book;
import study.codereview.book.domain.vo.Category;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class BookTest {

    @Test
    void 정상_생성() {
        // given
        String bookName = "hello";
        String categoryName = "개발";
        int costValue = 5000;

        // when & then
        assertDoesNotThrow(() -> Book.createDefault(bookName, categoryName, costValue));
    }

    @Test
    void 할인_후의_금액_계산() {
        // given
        String bookName = "hello";
        String categoryName = "개발";
        int costValue = 5000;

        Book book = Book.createDefault(bookName, categoryName, costValue);
        Category category = Category.DEVELOP;
        int expected = category.calculateAfterDiscount(costValue);

        // when
        int costAfterDiscount = book.getCostAfterDiscount();

        // then
        assertThat(costAfterDiscount).isEqualTo(expected);
    }
}
