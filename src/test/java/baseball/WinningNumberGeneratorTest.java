package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComputerTest {
    @RepeatedTest(1)
    void 숫자야구게임에_유효하지않은_숫자일경우_예외가발생한다() {
        List<Integer> winningNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        String testNumber = winningNumber.stream().map(String::valueOf).reduce("", String::concat);

        assertThatCode(() -> new BaseballNumber(testNumber)).doesNotThrowAnyException();
    }

    @Test
    void 정답숫자를_정상_생성한다() {
        Computer computer = new Computer();

        List<Integer> winnings = computer.createWinningNumber();
        String result = winnings.stream().map(String::valueOf).collect(Collectors.joining());
        
        assertThatCode(() -> new BaseballNumber(result)).doesNotThrowAnyException();
    }
    //같은 인덱스에 값이 같으면 스트라이크
    //볼 : contains 하는데 스트라이크 갯수만큼 차감
    //낫싱: contains 없을 때
    @ParameterizedTest
    @CsvSource({
            "123, 1",
            "456, 1",
            "789, 0"
    })
    void 같은_인덱스일경우_스트라이크_반환한다(String input, int excepted) {
        List<Integer> winningNumber = Arrays.asList(4,2,5);
        BaseballNumber baseballNumber = new BaseballNumber(input);
        Computer computer = new Computer();

        assertThat(computer.checkStrike()).isEqualTo(excepted);;
    }
}
