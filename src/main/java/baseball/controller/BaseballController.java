package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.HintGenerator;
import baseball.domain.WinningNumberGenerator;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballController {
    private final List<Integer> winningNumber;

    public BaseballController(WinningNumberGenerator winningNumberGenerator) {
        this.winningNumber = winningNumberGenerator.createWinningNumber();
    }

    public void run() {

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            BaseballNumber baseballNumber = new BaseballNumber(userInput);
            List<Integer> expectNumber = baseballNumber.getNumber();

            HintGenerator hintGenerator = new HintGenerator(winningNumber, expectNumber);
            List<Integer> hintResult = hintGenerator.generateCount();

            OutputView outputView = new OutputView();
            outputView.displayResult(hintResult);

            if (hintResult.get(1) == 3) {
                break;
            }

        }
    }
}
