package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HintGeneratorTest {
    @ParameterizedTest
    @CsvSource({
            "123, 1, 0",
            "456, 1, 1",
            "789, 0, 0"
    })
    void 같은_인덱스일경우_스트라이크_반환한다(String input, int exceptedStrike, int expectedBall) {
        List<Integer> winningNumber = Arrays.asList(4,2,5);
        BaseballNumber baseballNumber = new BaseballNumber(input);

        HintGenerator hintGenerator = new HintGenerator(baseballNumber.getNumber(), winningNumber);

        assertThat(hintGenerator.generateCount().get(1)).isEqualTo(exceptedStrike);
        assertThat(hintGenerator.generateCount().get(0)).isEqualTo(expectedBall);
    }
}
