package baseball.domain;

import baseball.utils.ThreeDigitNumber;
import camp.nextstep.edu.missionutils.Randoms;

public class AnswerFactory {

    public Answer create() {
        int[] candidateDigits = null;
        do {
            candidateDigits = ThreeDigitNumber.toArray(Randoms.pickNumberInRange(100, 999));
        } while (ThreeDigitNumber.hasDuplicateDigits(candidateDigits));

        return Answer.of(candidateDigits[0], candidateDigits[1], candidateDigits[2]);
    }

}
