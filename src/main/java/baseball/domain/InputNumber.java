package baseball.domain;

public class InputNumber {

    private final int first;
    private final int second;
    private final int third;

    private InputNumber(final int first, final int second, final int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static InputNumber of(final int first, final int second, final int third) {
        return new InputNumber(first, second, third);
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    @Override
    public String toString() {
        return String.format("InputNumber{first=%d, second=%d, third=%d}", first, second, third);
    }

}
