package study.codereview.book.domain.vo;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.codereview.book.exception.exceptions.CategoryNotFoundException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CategoryTest {

    @ParameterizedTest(name = "이름이 [{0}]인 경우 카테고리 조회")
    @ValueSource(strings = {"개발", "교양", "재테크"})
    void 카테고리_이름_조회_테스트(final String title) {
        // when & then
        assertDoesNotThrow(() -> Category.findByTitle(title));
    }

    @Test
    void 등록된_카테고리_이름이_아니면_예외가_발생한다() {
        // given
        String name = "hello";

        // when & then
        assertThatThrownBy(() -> Category.findByTitle(name))
                .isInstanceOf(CategoryNotFoundException.class);
    }
}

