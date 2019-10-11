package com.alok.jwttokenservice.util.exception;

/**
 * @author asachan@app-scoop.com
 */
public class ExceptionUtil {

    public static void throwException(final String message, final ErrorCode errorCode) {
        throw new JwtTokenBusinessException(message, errorCode);
    }
}
