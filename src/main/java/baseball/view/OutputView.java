package baseball.view;

import java.util.List;

public class OutputView {

    public void displayResult(List<Integer> hintResult) {
        int ballResult = hintResult.get(0);
        int strikeResult = hintResult.get(1);

        StringBuilder result = new StringBuilder();

        if (ballResult > 0) {
            result.append(ballResult).append("볼 ");
        }

        if (strikeResult > 0) {
            result.append(strikeResult).append("스트라이크 ");
        }

        if (result.length() == 0) {
            result.append("낫싱");
        }

        System.out.println(result);

        if (strikeResult == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
