package com.alok.jwttokenservice.config.oauth;

import com.alok.jwttokenservice.adapter.user.UserAdapter;
import com.alok.jwttokenservice.config.Constant;
import com.alok.jwttokenservice.config.OAuth2AccessTokenResponse;
import com.alok.jwttokenservice.dto.UserDto;
import com.alok.jwttokenservice.service.UserService;
import com.alok.jwttokenservice.util.Error;
import com.alok.jwttokenservice.util.exception.JwtTokenBusinessException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Data
public class TokenEnhancerImpl implements TokenEnhancer {

    private final UserService userService;
    private final Error error;
    private final UserAdapter userAdapter;

    @Autowired
    public TokenEnhancerImpl(final UserService userService, final Error error, final UserAdapter userAdapter) {
        this.userService = userService;
        this.error = error;
        this.userAdapter = userAdapter;
    }

    @Override
    public OAuth2AccessToken enhance(final OAuth2AccessToken accessToken, final OAuth2Authentication authentication) {

        final OAuth2AccessTokenResponse defaultOAuth2AccessToken = new OAuth2AccessTokenResponse(accessToken);
        UserDto userDto = null;

        log.info("Enhancing oauth token to include user info");
        if (authentication.getOAuth2Request().getRequestParameters().get(Constant.GRANT_TYPE)
                .equals(Constant.GRANT_TYPE_SOCIAL)) {
            try {
                userDto = userAdapter.adapt(userService.getUserByEmail(authentication.getPrincipal().toString()));
                userDto.setStatus(Constant.USER_STATUS_ACTIVE);
            } catch (final JwtTokenBusinessException e) {
                log.error(error.getUserNotFoundByEmail(), authentication.getPrincipal().toString());
                throw new InvalidRequestException(error.getUserNotRegister());
            }
        } else if (authentication.getOAuth2Request().getRequestParameters().get(Constant.GRANT_TYPE)
                .equals(Constant.GRANT_TYPE_OTP)) {

            try {
                userDto = userAdapter.adapt(userService.getUserByEmail(authentication.getPrincipal().toString()));
            } catch (final JwtTokenBusinessException ex) {
                log.error(error.getUserNotFoundByEmail(), authentication.getPrincipal().toString());
                throw new InvalidRequestException(error.getUserNotRegister());
            }
        } else {
            final User user = (User) authentication.getPrincipal();
            try {
                userDto = userAdapter.adapt(userService.getUserByEmail(user.getUsername()));
            } catch (final JwtTokenBusinessException e) {
                log.error(error.getUserNotFoundByEmail(), user.getUsername());
            }
        }

        if (Constant.USER_STATUS_ACTIVE != userDto.getStatus()) {
        }

        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put(Constant.USER_INFO_KEY, UserResponse.transform(userDto));
        defaultOAuth2AccessToken.getAdditionalInformation().putAll(additionalInfo);
        return defaultOAuth2AccessToken;
    }

    @Data
    static class UserResponse implements Serializable {

        private static final long serialVersionUID = 4447118929715893875L;

        private Long id;
        private String fullName;
        private String email;
        private String mobileNumber;
        private String status;

        public static UserResponse transform(final UserDto userDto) {
            final UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(userDto, userResponse);
            return userResponse;
        }
    }

}
