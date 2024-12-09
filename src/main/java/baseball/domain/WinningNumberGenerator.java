package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberGenerator {

//    public List<Integer> createWinningNumber() {
//        return Randoms.pickUniqueNumbersInRange(1,9,3);
//    }

    public List<Integer> createWinningNumber() {
        Set<Integer> uniqueNumbers = new HashSet<>(); // 중복 방지
        while (uniqueNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            uniqueNumbers.add(number); // 중복 시도 시 추가되지 않음
        }
        return new ArrayList<>(uniqueNumbers); // Set을 List로 변환
    }
}


