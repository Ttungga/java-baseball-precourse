package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AnswerFactoryTest {

    private final AnswerFactory answerFactory = new AnswerFactory();

    @Test
    void 정답의_각_자리수는_서로_중복되지_않아야_한다() {
        // given and when
        final Answer answer = answerFactory.create();

        // then
        assertThat(answer.getFirst() != answer.getSecond()
                && answer.getSecond() != answer.getThird()
                && answer.getThird() != answer.getFirst()).isTrue();
    }

}
