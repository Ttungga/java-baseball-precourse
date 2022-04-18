package baseball;

import baseball.application.BaseballGameProcessor;
import baseball.domain.AnswerFactory;
import baseball.domain.InputNumberFactory;
import baseball.service.InputValidator;
import baseball.service.MessagePrinter;
import baseball.service.ResultCalculator;

public class Application {
    public static void main(String[] args) {
        final BaseballGameProcessor baseballGameProcessor = new BaseballGameProcessor(new AnswerFactory()
                , new InputNumberFactory(new InputValidator())
                , new ResultCalculator()
                , new MessagePrinter());
        baseballGameProcessor.startGame();
    }
}
