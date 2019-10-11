package com.alok.jwttokenservice.config.oauth;

import com.alok.jwttokenservice.config.Constant;
import com.alok.jwttokenservice.util.exception.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

/**
 * @author asachan@app-scoop.com
 */

public class SprkAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

    protected ResponseEntity<OAuth2Exception> enhanceResponse(final ResponseEntity<OAuth2Exception> response) {
        final OAuth2Exception oAuth2Exception = response.getBody();
        oAuth2Exception.addAdditionalInformation(Constant.ERROR_CODE, oAuth2Exception.getOAuth2ErrorCode());
        oAuth2Exception.addAdditionalInformation(Constant.ERROR_DESCRIPTION, ErrorCode.ACCESS_DENIED.getMessage());
        oAuth2Exception.addAdditionalInformation(Constant.DETAIL_ERROR_MESSAGE, oAuth2Exception.getMessage());
        return response;
    }

}
