package com.alok.jwttokenservice.security;

import com.alok.jwttokenservice.config.oauth.ResourceServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Value("${oauth.ios.client.id}")
    private String iosClientId;

    @Value("${oauth.ios.client.secret}")
    private String iosClientSecret;

    @Value("${oauth.granttype}")
    private String grantType;

    @Value("${oauth.authorities}")
    private String authorities;

    @Value("${oauth.scope}")
    private String scope;

    @Value("${oauth.expiration}")
    private Integer expiration;

    @Override
    public ClientDetails loadClientByClientId(final String clientId) throws ClientRegistrationException {
        final BaseClientDetails baseClientDetails = new BaseClientDetails(iosClientId,
                ResourceServerConfig.RESOURCE_ID, scope, grantType, authorities);
        baseClientDetails.setClientSecret(iosClientSecret);
        baseClientDetails.setAccessTokenValiditySeconds(expiration);
        return baseClientDetails;
    }
}
