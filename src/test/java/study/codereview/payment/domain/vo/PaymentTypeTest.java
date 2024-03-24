package study.codereview.payment.domain.vo;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.codereview.payment.exception.exceptions.PaymentTypeNotFoundException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class PaymentTypeTest {

    @ParameterizedTest(name = "이름이 [{0}]인 경우 계산 방법 조회")
    @ValueSource(strings = {"CASH", "CARD"})
    void 계산_방법_조회_성공(final String name) {
        // when & then
        assertDoesNotThrow(() -> PaymentType.findByName(name));
    }

    @Test
    void 등록된_계산_방법이_아니면_예외가_발생한다() {
        // given
        String name = "hello";

        // when & then
        assertThatThrownBy(() -> PaymentType.findByName(name))
                .isInstanceOf(PaymentTypeNotFoundException.class);
    }
}
