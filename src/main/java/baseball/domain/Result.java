package baseball.domain;

public class Result {

    private int strikeCount = 0;
    private int ballCount = 0;

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(final int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(final int ballCount) {
        this.ballCount = ballCount;
    }

}
