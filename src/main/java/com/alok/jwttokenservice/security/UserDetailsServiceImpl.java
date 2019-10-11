package com.alok.jwttokenservice.security;

import com.alok.jwttokenservice.config.Constant;
import com.alok.jwttokenservice.entity.UserEntity;
import com.alok.jwttokenservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByEmail(email);
        if (Objects.nonNull(userEntity)) {
            if (Constant.USER_STATUS_PENDING.equals(userEntity.getStatus())) {
                throw new InvalidRequestException("User is not active,please contact admin");
            }
            final User userDetails = new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true,
                    Arrays.asList(new SimpleGrantedAuthority("USER")));
            return userDetails;
        } else {
            throw new UsernameNotFoundException("Username not found");
        }

    }

}
