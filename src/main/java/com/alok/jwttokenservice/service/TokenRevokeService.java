package com.alok.jwttokenservice.service;

import com.alok.jwttokenservice.config.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor(
        onConstructor = @__({@Autowired, @Lazy}))
@Lazy
public class TokenRevokeService {

    private final DefaultTokenServices tokenServices;
    private final TokenStore tokenStore;
    private final ApplicationConfig applicationConfig;

    public void revokeToken(final String email) {
        final List<String> tokenValues = new ArrayList<>();
        final Collection<OAuth2AccessToken> tokens = tokenStore
                .findTokensByClientIdAndUserName(applicationConfig.getClientId(), email);
        if (tokens != null) {
            for (final OAuth2AccessToken token : tokens) {
                tokenValues.add(token.getValue());
            }
        }
        if (tokenValues != null && !tokenValues.isEmpty()) {
            tokenValues.forEach(tokenServices::revokeToken);
        }

    }
}
