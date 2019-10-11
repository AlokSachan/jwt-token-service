package com.alok.jwttokenservice.util.exception;

/**
 * @author asachan@app-scoop.com
 */
public interface JwtTokenException {

    String getMessage();

    ErrorCode getErrorCode();
}
