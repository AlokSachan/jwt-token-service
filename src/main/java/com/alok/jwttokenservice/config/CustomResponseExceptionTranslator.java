package com.alok.jwttokenservice.config;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;

/**
 * @author asachan@app-scoop.com
 */
public class CustomResponseExceptionTranslator extends DefaultWebResponseExceptionTranslator {

    @Override
    public ResponseEntity<OAuth2Exception> translate(final Exception e) throws Exception {
        final ResponseEntity<OAuth2Exception> oAuth2ExceptionEntity = super.translate(e);
        final OAuth2Exception oAuth2Exception = oAuth2ExceptionEntity.getBody();
        oAuth2Exception.addAdditionalInformation(Constant.ERROR_CODE, oAuth2Exception.getOAuth2ErrorCode());
        oAuth2Exception.addAdditionalInformation(Constant.ERROR_DESCRIPTION, oAuth2Exception.getMessage());
        oAuth2Exception.addAdditionalInformation(Constant.DETAIL_ERROR_MESSAGE, oAuth2Exception.getMessage());
        return oAuth2ExceptionEntity;
    }
}
