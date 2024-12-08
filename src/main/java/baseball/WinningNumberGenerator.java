package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class WinningNumberGenerator {

    public List<Integer> createWinningNumber() {
        return Randoms.pickUniqueNumbersInRange(1,9,3);
    }
}
