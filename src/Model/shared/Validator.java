package Model.shared;

import Config.errors.StringException;

public class Validator {

    public static void isNullEmpty(String key, String value) throws StringException {
        if (value == null || value.isEmpty()) {
            throw new StringException(String.format("BAD REQUEST, %s is empty or null", key));
        }
    }

    public static boolean exists(String value) {
        return (value != null && !value.isEmpty());
    }
}
