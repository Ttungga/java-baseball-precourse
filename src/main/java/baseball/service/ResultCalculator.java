package baseball.service;

import baseball.domain.Answer;
import baseball.domain.InputNumber;
import baseball.domain.Result;

public class ResultCalculator {

    final Result result = new Result();

    public Result initiateResult() {
        result.setBallCount(0);
        result.setStrikeCount(0);
        return result;
    }

    public Result calculateResult(final Answer answer, final InputNumber inputNumber) {
        result.setStrikeCount(getStrikeCount(answer, inputNumber));
        result.setBallCount(getBallCount(answer, inputNumber));
        return result;
    }

    private int getStrikeCount(final Answer answer, final InputNumber inputNumber) {
        int strikeCount = 0;
        if (answer.getFirst() == inputNumber.getFirst()) {
            strikeCount++;
        }
        if (answer.getSecond() == inputNumber.getSecond()) {
            strikeCount++;
        }
        if (answer.getThird() == inputNumber.getThird()) {
            strikeCount++;
        }
        return strikeCount;
    }

    private int getBallCount(final Answer answer, final InputNumber inputNumber) {
        int ballCount = 0;
        if ((inputNumber.getFirst() == answer.getSecond()) || (inputNumber.getFirst() == answer.getThird())) {
            ballCount++;
        }
        if ((inputNumber.getSecond() == answer.getFirst()) || (inputNumber.getSecond() == answer.getThird())) {
            ballCount++;
        }
        if ((inputNumber.getThird() == answer.getFirst()) || (inputNumber.getThird() == answer.getSecond())) {
            ballCount++;
        }
        return ballCount;
    }

}
