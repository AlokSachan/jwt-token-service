package com.alok.jwttokenservice.util.exception;

/**
 * @author asachan@app-scoop.com
 */
public class JwtTokenBusinessException extends RuntimeException implements JwtTokenException {

    private static final long serialVersionUID = 1423964300065071050L;

    private final String message;
    private final ErrorCode errorCode;

    public JwtTokenBusinessException(final Throwable e, final String message, final ErrorCode errorCode) {
        super(message, e);
        this.message = message;
        this.errorCode = errorCode;
    }

    public JwtTokenBusinessException(final String message, final ErrorCode errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
