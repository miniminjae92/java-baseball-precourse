package baseball;

import java.util.List;

public class HintGenerator {
    private final List<Integer> winningNumbers;
    private final List<Integer> expectedNumbers;
    private int strikeCount;
    private int ballCount;

    public HintGenerator(List<Integer> winningNumbers, List<Integer> expectedNumbers) {
        this.winningNumbers = winningNumbers;
        this.expectedNumbers = expectedNumbers;
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int checkStrike() {
        strikeCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (winningNumbers.get(i) == expectedNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int checkBall() {
        ballCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (winningNumbers.contains(expectedNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount - strikeCount;
    }
}
