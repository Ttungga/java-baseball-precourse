package baseball.domain;

public class Answer {

    private final int first;
    private final int second;
    private final int third;

    private Answer(final int first, final int second, final int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static Answer of(final int first, final int second, final int third) {
        return new Answer(first, second, third);
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
        return String.format("Answer{first=%d, second=%d, third=%d}", first, second, third);
    }

}
