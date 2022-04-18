package baseball.utils;

public class ThreeDigitNumber {

    public static int[] toArray(final int threeDigitNumber) {
        final int[] digits = new int[3];
        digits[0] = (threeDigitNumber / 100) % 10;
        digits[1] = (threeDigitNumber / 10) % 10;
        digits[2] = threeDigitNumber % 10;
        return digits;
    }

    public static boolean hasDuplicateDigits(final int[] digits) {
        return digits[0] == digits[1] || digits[1] == digits[2] || digits[2] == digits[0];
    }

}
