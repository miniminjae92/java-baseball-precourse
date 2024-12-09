package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HintGenerator {
    private final List<Integer> winningNumbers;
    private final List<Integer> expectedNumbers;

    public HintGenerator(List<Integer> winningNumbers, List<Integer> expectedNumbers) {
        this.winningNumbers = winningNumbers;
        this.expectedNumbers = expectedNumbers;
    }

    public List<Integer> generateCount() {
        int strikeCount = checkStrike();
        int ballCount = checkBall(strikeCount);

        List<Integer> totalCounts = new ArrayList<>();
        totalCounts.add(ballCount);
        totalCounts.add(strikeCount);

        return totalCounts;
    }

    private int checkStrike() {
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (Objects.equals(winningNumbers.get(i), expectedNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int checkBall(int strikeCount) {
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (winningNumbers.contains(expectedNumbers.get(i))) {
                count++;
            }
        }
        return count - strikeCount;
    }
}
