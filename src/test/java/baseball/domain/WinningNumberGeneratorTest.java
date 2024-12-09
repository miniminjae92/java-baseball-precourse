package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class WinningNumberGeneratorTest {
    @RepeatedTest(1)
    void 숫자야구게임에_유효하지않은_숫자일경우_예외가발생한다() {
        List<Integer> winningNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        String testNumber = winningNumber.stream().map(String::valueOf).reduce("", String::concat);

        assertThatCode(() -> new BaseballNumber(testNumber)).doesNotThrowAnyException();
    }

    @Test
    void 정답숫자를_정상_생성한다() {
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();

        List<Integer> winnings = winningNumberGenerator.createWinningNumber();
        String result = winnings.stream().map(String::valueOf).collect(Collectors.joining());

        assertThatCode(() -> new BaseballNumber(result)).doesNotThrowAnyException();
    }
}
