package baseball;

import baseball.controller.BaseballController;
import baseball.domain.WinningNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();

        while (true) {
            BaseballController baseballController = new BaseballController(winningNumberGenerator);

            baseballController.run();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();

            if (userInput.equals("2")) {
                break;
            }
            if (!userInput.equals("1")) {
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            }
        }
    }
}
