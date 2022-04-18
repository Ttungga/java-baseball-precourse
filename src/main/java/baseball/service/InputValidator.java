package baseball.service;

import baseball.utils.ThreeDigitNumber;

public class InputValidator {

    public void validateInput(final String inputText) throws IllegalArgumentException {
        checkNullOrEmpty(inputText);
        checkBlank(inputText);
        checkNumberFormat(inputText);
        final int inputNumber = Integer.parseInt(inputText);
        checkThreeDigitNumber(inputNumber);
        checkDuplicateDigits(inputNumber);
    }

    private void checkNullOrEmpty(final String inputText) {
        if (inputText == null || "".equals(inputText)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBlank(final String inputText) {
        if (inputText.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberFormat(final String inputText) {
        try {
            Integer.parseInt(inputText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkThreeDigitNumber(final int inputNumber) {
        if (inputNumber < 100 || inputNumber > 999) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateDigits(final int inputNumber) {
        if (ThreeDigitNumber.hasDuplicateDigits(ThreeDigitNumber.toArray(inputNumber))) {
            throw new IllegalArgumentException();
        }
    }

}
