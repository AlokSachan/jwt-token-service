package com.alok.jwttokenservice.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OAuth2AccessTokenResponse extends DefaultOAuth2AccessToken {

    private static final long serialVersionUID = 7828066870208389754L;

//    public OAuth2AccessTokenResponse(final String value) {
//        super(value);
//    }

    public OAuth2AccessTokenResponse(final OAuth2AccessToken accessToken) {
        super(accessToken);
    }
}
