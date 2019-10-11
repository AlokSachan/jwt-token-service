package com.alok.jwttokenservice.config.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

/**
 * @author asachan@app-scoop.com
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "";
    /* Swagger UI. */
    private static final String[] AUTH_WHITELIST = {"/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs",
            "/webjars/**"};

    @Bean
    public OAuth2AuthenticationEntryPoint oAuth2AuthenticationEntryPoint() {
        return new SprkAuthenticationEntryPoint();
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests().antMatchers("/user/register").permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll().anyRequest().authenticated();
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(oAuth2AuthenticationEntryPoint());
        resources.resourceId(RESOURCE_ID);
    }

}
