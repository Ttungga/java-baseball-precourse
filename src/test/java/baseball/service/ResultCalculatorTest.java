package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Answer;
import baseball.domain.InputNumber;
import baseball.domain.Result;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {

    private final ResultCalculator resultCalculator = new ResultCalculator();
    private final Answer answer = Answer.of(1, 2, 3);

    @Test
    void 일치하는_숫자가_없으면_0볼_0스트라이크() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(4, 5, 6));
        inputNumbers.add(InputNumber.of(7, 8, 9));
        inputNumbers.add(InputNumber.of(9, 0, 4));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(0);
            assertThat(result.getStrikeCount()).isEqualTo(0);
        }
    }

    @Test
    void 노_볼_원_스트라이크() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(1, 4, 5));
        inputNumbers.add(InputNumber.of(4, 2, 0));
        inputNumbers.add(InputNumber.of(4, 0, 3));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(0);
            assertThat(result.getStrikeCount()).isEqualTo(1);
        }
    }

    @Test
    void 노_볼_투_스트라이크() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(1, 2, 0));
        inputNumbers.add(InputNumber.of(1, 0, 3));
        inputNumbers.add(InputNumber.of(4, 2, 3));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(0);
            assertThat(result.getStrikeCount()).isEqualTo(2);
        }
    }

    @Test
    void 쓰리_스트라이크() {
        // given
        final InputNumber inputNumber = InputNumber.of(1, 2, 3);

        // when
        final Result result = resultCalculator.calculateResult(answer, inputNumber);

        // then
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void 원_볼_노_스트라이크() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(4, 1, 5));
        inputNumbers.add(InputNumber.of(2, 4, 5));
        inputNumbers.add(InputNumber.of(4, 3, 5));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(1);
            assertThat(result.getStrikeCount()).isEqualTo(0);
        }
    }

    @Test
    void 원_볼_원_스트라이크() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(4, 1, 3));
        inputNumbers.add(InputNumber.of(1, 3, 4));
        inputNumbers.add(InputNumber.of(3, 2, 4));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(1);
            assertThat(result.getStrikeCount()).isEqualTo(1);
        }
    }

    @Test
    void 투_볼_노_스트라이크() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(4, 3, 2));
        inputNumbers.add(InputNumber.of(3, 4, 1));
        inputNumbers.add(InputNumber.of(2, 1, 4));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(2);
            assertThat(result.getStrikeCount()).isEqualTo(0);
        }
    }

    @Test
    void 투_볼_원_스트라이크() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(1, 3, 2));
        inputNumbers.add(InputNumber.of(3, 2, 1));
        inputNumbers.add(InputNumber.of(2, 1, 3));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(2);
            assertThat(result.getStrikeCount()).isEqualTo(1);
        }
    }

    @Test
    void 쓰리_볼() {
        // given
        final List<InputNumber> inputNumbers = new ArrayList<>();
        inputNumbers.add(InputNumber.of(3, 1, 2));
        inputNumbers.add(InputNumber.of(2, 3, 1));

        // when and then
        for (InputNumber inputNumber : inputNumbers) {
            Result result = resultCalculator.calculateResult(answer, inputNumber);
            assertThat(result.getBallCount()).isEqualTo(3);
            assertThat(result.getStrikeCount()).isEqualTo(0);
        }
    }

}
