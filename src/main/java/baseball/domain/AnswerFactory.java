package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class AnswerFactory {

    public Answer create() {
        final int firstDigit = getFirstDigit();
        final int secondDigit = getSecondDigit(firstDigit);
        final int thirdDigit = getThirdDigit(firstDigit, secondDigit);
        return Answer.of(firstDigit, secondDigit, thirdDigit);
    }

    private int getFirstDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private int getSecondDigit(final int firstDigit) {
        int secondDigit = Randoms.pickNumberInRange(0, 9);
        if (firstDigit == secondDigit) {
            return getSecondDigit(firstDigit);
        }
        return secondDigit;
    }

    private int getThirdDigit(final int firstDigit, final int secondDigit) {
        int thirdDigit = Randoms.pickNumberInRange(0, 9);
        if (firstDigit == thirdDigit || secondDigit == thirdDigit) {
            return getThirdDigit(firstDigit, secondDigit);
        }
        return thirdDigit;
    }
}
