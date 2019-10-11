package com.alok.jwttokenservice.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Objects;

public class AppSecurityContextHolder {

    public static String getLoggedInUserEmail() {
        String email = null;
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)) {
            final User user = (User) authentication.getPrincipal();
            email = user.getUsername();
        }
        return email;
    }

    public static String getAuthToken() {
        String token = "";
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)) {
            final OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) authentication
                    .getDetails();
            if (Objects.nonNull(oAuth2AuthenticationDetails)) {
                token = oAuth2AuthenticationDetails.getTokenValue();
            }
        }
        return token;
    }
}
