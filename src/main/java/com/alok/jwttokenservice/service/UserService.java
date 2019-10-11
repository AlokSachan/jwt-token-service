package com.alok.jwttokenservice.service;


import com.alok.jwttokenservice.entity.UserEntity;
import com.alok.jwttokenservice.repository.UserRepository;
import com.alok.jwttokenservice.util.Error;
import com.alok.jwttokenservice.util.exception.ErrorCode;
import com.alok.jwttokenservice.util.exception.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author asachan@app-scoop.com
 */
@Service
@RequiredArgsConstructor(
        onConstructor = @__({@Autowired, @Lazy}))
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final Error error;
    private final TokenRevokeService tokenRevokeService;

    @Transactional
    public UserEntity register(final UserEntity userEntity) {
        UserEntity existUserEntity = userRepository.findByEmail(userEntity.getEmail());
        if (null == existUserEntity) {
            existUserEntity = userRepository.save(userEntity);
        }
        return existUserEntity;
    }

    public UserEntity getUserById(final long userId) {
        final UserEntity userById = userRepository.findOne(userId);
        if (null == userById) {
            ExceptionUtil.throwException(error.getUserNotFoundById(), ErrorCode.USER_DOES_NOT_EXIST);
        }
        return userById;
    }

    public UserEntity getUserByEmail(final String email) {
        final UserEntity userByEmail = userRepository.findByEmail(email);
        if (null == userByEmail) {
            ExceptionUtil.throwException(error.getUserNotFoundByEmail(), ErrorCode.USER_DOES_NOT_EXIST);
        }
        return userByEmail;
    }

    @Transactional
    public void updateUser(final UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
