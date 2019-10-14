package com.alok.jwttokenservice.config.oauth;

import springfox.documentation.service.AuthorizationScope;

public class Scope {

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations"),
                new AuthorizationScope("foo", "Access foo API")};
        return scopes;
    }
}
