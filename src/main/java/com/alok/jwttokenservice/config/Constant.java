package com.alok.jwttokenservice.config;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author asachan@app-scoop.com
 */

@NoArgsConstructor(
        access = PRIVATE)
public class Constant {

    public static final String GRANT_TYPE = "grant_type";
    public static final String GRANT_TYPE_SOCIAL = "social";
    public static final String USER_NAME = "username";
    public static final String MOBILE_NUMBER = "mobileNumber";
    public static final String SOCIAL_TOKEN = "socialtoken";
    public static final String SOCIAL_TYPE = "socialtype";
    public static final String GRANT_TYPE_OTP = "otp";
    public static final String OTP = "otp";
    public static final String EMAIL = "email";
    public static final String OTP_TYPE = "otptype";
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_DESCRIPTION = "errorDescription";
    public static final String DETAIL_ERROR_MESSAGE = "detailErrorMessage";
    public static final String USER_STATUS_PENDING = "PENDING";
    public static final String USER_STATUS_ACTIVE = "ACTIVE";
    public final static String REGISTRATION = "REGISTRATION";
    public final static String RESET_PASSWORD = "RESET_PASSWORD";
    public static final String ADAPTER_INPUT_VALIDATION = "Input must not be null!";
    public static String USER_INFO_KEY = "userInfo";

}
