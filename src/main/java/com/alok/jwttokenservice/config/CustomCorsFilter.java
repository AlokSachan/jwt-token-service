package com.alok.jwttokenservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author asachan@app-scoop.com
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class CustomCorsFilter extends OncePerRequestFilter {

    @Value("${custom.cors.allowOrigin:*}")
    private String allowOrigin;

    @Value("${custom.cors.allowMethods:GET, POST, PUT, DELETE, OPTIONS, PATCH}")
    private String allowMethods;

    @Value("${custom.cors.allowHeaders:Content-Type, Authorization, Accept, Cache-Control}")
    private String allowHeaders;

    @Value("${custom.cors.allowCredentials:true}")
    private String allowCredentials;

    @Value("${custom.cors.maxAge:3600}")
    private String maxAge;

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin", allowOrigin);

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods", allowMethods);
            response.addHeader("Access-Control-Allow-Headers", allowHeaders);
            response.addHeader("Access-Control-Allow-Credentials", allowCredentials);
            response.addHeader("Access-Control-Max-Age", maxAge);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
