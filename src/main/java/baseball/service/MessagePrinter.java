package baseball.service;

import baseball.domain.Result;

public class MessagePrinter {

    private final String INPUT_REQUEST = "숫자를 입력해주세요: ";
    private final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printInputRequestMessage() {
        System.out.println(INPUT_REQUEST);
    }

    public void printResultMessage(final Result result) {
        if (result.getBallCount() == 0 && result.getStrikeCount() == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(getResultMessage(result));
        if (result.getStrikeCount() == 3) {
            System.out.println(GAME_OVER);
        }
    }

    private String getResultMessage(final Result result) {
        final String ballMessage = getBallMessage(result);
        final String strikeMessage = "".equals(ballMessage) ? getStrikeMessage(result) : " " + getStrikeMessage(result);
        return ballMessage + strikeMessage;
    }

    private String getBallMessage(final Result result) {
        if (result.getBallCount() == 0) {
            return "";
        }
        return result.getBallCount() + "볼";
    }

    private String getStrikeMessage(final Result result) {
        if (result.getStrikeCount() == 0) {
            return "";
        }
        return result.getStrikeCount() + "스트라이크";
    }

}
