package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> number;

    public BaseballNumber(String userInput) {
        this.number = validateNumber(userInput);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private List<Integer> validateNumber(String userInput) {
        String baseballNumberRegex = "^[1-9]{3}$";

        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!userInput.matches(baseballNumberRegex)) {
            throw new IllegalArgumentException("Invalid baseball number");
        }

        if (hasDuplicateInput(userInput)) {
            throw new IllegalArgumentException();
        }

        return getValidNumbers(userInput);
    }

    private Boolean hasDuplicateInput(String userInput) {
        return userInput.chars()
                .distinct()
                .count() != userInput.length();
    }

    public List<Integer> getValidNumbers(String userInput) {
        List<Integer> validNumbers = new ArrayList<>();

        for (char c : userInput.toCharArray()) {
            validNumbers.add(Character.getNumericValue(c));
        }

        return validNumbers;
    }
}
