package baseball.domain;

import baseball.service.InputValidator;
import baseball.utils.ThreeDigitNumber;

public class InputNumberFactory {

    private final InputValidator inputValidator;

    public InputNumberFactory(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public InputNumber create(final String inputText) throws IllegalArgumentException {
        inputValidator.validateInput(inputText);
        int[] inputDigits = ThreeDigitNumber.toArray(Integer.parseInt(inputText));
        return InputNumber.of(inputDigits[0], inputDigits[1], inputDigits[2]);
    }

}
