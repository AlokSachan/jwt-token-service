package com.alok.jwttokenservice.util.exception;

/**
 * @author asachan@app-scoop.com
 */
public enum ErrorCode {
    ACCESS_DENIED("Full authentication is required to access this resource"), USER_ALREADY_EXISTS(
            "User already exist"), USER_DOES_NOT_EXIST("Requested user does not exist"), OTP_INVALID(
            "Invalid OTP"), UNSUPPORTED_FILE_FORMAT(
            "Plz verify the file you have selected"), OTP_NOT_FOUND_USER(
            "Otp does not exist for user"), FILE_NOT_UPLOADED(
            "Requested media file is not uploaded"), UNDEFINED_USER_LOCATION(
            "user location is undefined, please enter valid location"), KEY_NAME_ALREADY_EXISTS(
            "Key already exists."), FILE_NOT_FOUND(
            "File not found for given keyName");

    private final String message;

    private ErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
