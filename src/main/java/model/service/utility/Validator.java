package model.service.utility;

import model.exсeptions.InvalidInputRuntimeException;

public class Validator {
    public static final String CHECK_NUMBER = "-?(\\d+)";

    public static boolean isNumber(String value) {
        if (value.matches(CHECK_NUMBER))
            return true;
        throw new InvalidInputRuntimeException(InvalidInputRuntimeException.WRONG_INPUT_TYPE);
    }

    public static boolean checkPositiveNumber(int value) {
        if (value > 0) {
            return true;
        }
        throw new InvalidInputRuntimeException(InvalidInputRuntimeException.NEGATIVE_VALUE);
    }
}
