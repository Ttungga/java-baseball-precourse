package baseball.application;

import baseball.domain.Answer;
import baseball.domain.AnswerFactory;
import baseball.domain.InputNumber;
import baseball.domain.InputNumberFactory;
import baseball.domain.Result;
import baseball.service.MessagePrinter;
import baseball.service.ResultCalculator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameProcessor {

    private final AnswerFactory answerFactory;
    private final InputNumberFactory inputNumberFactory;
    private final ResultCalculator resultCalculator;
    private final MessagePrinter messagePrinter;

    public BaseballGameProcessor(final AnswerFactory answerFactory,
                                 final InputNumberFactory inputNumberFactory,
                                 final ResultCalculator resultCalculator,
                                 final MessagePrinter messagePrinter) {
        this.answerFactory = answerFactory;
        this.inputNumberFactory = inputNumberFactory;
        this.resultCalculator = resultCalculator;
        this.messagePrinter = messagePrinter;
    }

    public void startGame() {
        final Answer answer = answerFactory.create();
        Result result = resultCalculator.initiateResult();
        while (result.getStrikeCount() != 3) {
            messagePrinter.printInputRequestMessage();
            InputNumber inputNumber = inputNumberFactory.create(Console.readLine());
            result = resultCalculator.calculateResult(answer, inputNumber);
            messagePrinter.printResultMessage(result);
        }
        finalizeGame(Console.readLine());
    }

    private void finalizeGame(final String finalInput) {
        validateFinalInput(finalInput);
        if ("1".equals(finalInput)) {
            startGame();
            return;
        }
    }

    private void validateFinalInput(final String finalInput) {
        if (!"1".equals(finalInput) && !"2".equals(finalInput)) {
            throw new IllegalArgumentException();
        }
    }

}
