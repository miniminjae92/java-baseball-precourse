package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberTest {
    @Test
    void 플레이어가_제출한_문자열이_숫자로_변환된다() {
        String input = "123";
        BaseballNumber baseballNumber = new BaseballNumber(input);


        assertThat(baseballNumber.getNumber()).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    void 숫자가_아닐_경우_예외가발생한다() {
        String input = "12a";

        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리_숫자가_아닐경우_예외가발생한다() {
        String input = "1234";

        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 널또는공백일경우_예외가발생한다(String text) {
        assertThatThrownBy(() -> new BaseballNumber(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "12",
            "abc",
            "-123",
            "-12",
            "012",
            "111"
    })
    void 유효하지않은숫자는_야구숫자검증에서_예외가발생한다(String text) {
        assertThatThrownBy(() -> new BaseballNumber(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
