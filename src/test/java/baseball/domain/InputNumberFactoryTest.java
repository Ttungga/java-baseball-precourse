package baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.service.InputValidator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputNumberFactoryTest {

    private final InputNumberFactory inputNumberFactory = new InputNumberFactory(new InputValidator());

    @Test
    void 입력값이_null이거나_빈_값이면_IllegalArgumentException을_발생시킨다() {
        // given
        final List<String> inputTexts = new ArrayList<>();
        inputTexts.add(null);
        inputTexts.add("");

        // when and then
        assertIllegalArgumentException(inputTexts);
    }

    @Test
    void 입력값에_공백이_포함되면_IllegalArgumentException을_발생시킨다() {
        // given
        final List<String> inputTexts = new ArrayList<>();
        inputTexts.add(" 123");
        inputTexts.add("123 ");
        inputTexts.add("1 23");

        // when and then
        assertIllegalArgumentException(inputTexts);
    }

    @Test
    void 입력값이_숫자가_아니면_IllegalArgumentException을_발생시킨다() {
        // given
        final List<String> inputTexts = new ArrayList<>();
        inputTexts.add("a123");
        inputTexts.add("123a");
        inputTexts.add("1a23");

        // when and then
        assertIllegalArgumentException(inputTexts);
    }

    @Test
    void 입력값이_세_자리_숫자가_아니면_IllegalArgumentException을_발생시킨다() {
        // given
        final List<String> inputTexts = new ArrayList<>();
        inputTexts.add("1");
        inputTexts.add("12");
        inputTexts.add("1234");

        // when and then
        assertIllegalArgumentException(inputTexts);
    }

    @Test
    void 입력값에_중복된_숫자가_포함되면_IllegalArgumentException을_발생시킨다() {
        // given
        final List<String> inputTexts = new ArrayList<>();
        inputTexts.add("112");
        inputTexts.add("111");

        // when and then
        assertIllegalArgumentException(inputTexts);
    }

    @Test
    void 입력값이_중복된_숫자가_없는_세_자리_수이면_InputNumber_객체를_반환한다() {
        // given
        final List<String> inputTexts = new ArrayList<>();
        inputTexts.add("123");
        inputTexts.add("987");
        inputTexts.add("135");
        inputTexts.add("246");

        // when and then
        for (String inputText : inputTexts) {
            assertThat(inputNumberFactory.create(inputText)).isInstanceOf(InputNumber.class);
        }
    }

    private void assertIllegalArgumentException(final List<String> inputTexts) {
        for (String inputText : inputTexts) {
            assertThatThrownBy(() -> {
                inputNumberFactory.create(inputText);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

}
