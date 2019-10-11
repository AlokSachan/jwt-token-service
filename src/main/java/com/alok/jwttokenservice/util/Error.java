package com.alok.jwttokenservice.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author asachan@app-scoop.com
 */

@Configuration
@PropertySource("classpath:error.properties")
@Getter
public class Error {

    @Value("${user.not.found.email}")
    private String userNotFoundByEmail;
    @Value("${unsupported.grant.type}")
    private String unsupportedGrantType;
    @Value("${social.type.parameter.missing}")
    private String socialTypeParameterMissing;
    @Value("${missing.social.token.parameter}")
    private String missingSocialTokenParameter;
    @Value("${missing.username.parameter}")
    private String missingUserNameParameter;
    @Value("${only.email.in.username.for.social.login}")
    private String onlyEmailInUserNameForSocialLogin;
    @Value("${unsupported.social.type}")
    private String unsupportedSocialType;
    @Value("${email.parameter.missing}")
    private String emailParameterMissing;
    @Value("${otp.type.parameter.missing}")
    private String otpTypeParameterMissing;
    @Value("${otp.parameter.missing}")
    private String otpParameterMissing;
    @Value("${incorrect.otp}")
    private String incorrectOTP;
    @Value("${user.not.register}")
    private String userNotRegister;
    @Value("${user.already.exist.for.email}")
    private String userAlreadyExistForEmail;
    @Value("${user.not.active}")
    private String userNotActive;
    @Value("${wrong.otp.value}")
    private String wrongOtpValue;
    @Value("${user.not.found.id}")
    private String userNotFoundById;
    @Value("${otp.not.found.used.id}")
    private String otpNotFoundByUserId;
    @Value("${file.not.valid}")
    private String fileNotValid;
    @Value("${invalid.request.parameter}")
    private String invalidRequestParameter;
    @Value("${unsupported.file.format}")
    private String unsupportedFileFormat;
    @Value("${undefined.user.location}")
    private String undefinedUserLocation;
    @Value("${file.not.uploaded}")
    private String fileNotUploaded;
    @Value("${keyname.already.exist.for.file}")
    private String keyNameAlreadyExistForFile;
}
