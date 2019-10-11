package com.alok.jwttokenservice.adapter.user;

import com.alok.jwttokenservice.config.Constant;
import com.alok.jwttokenservice.dto.UserDto;
import com.alok.jwttokenservice.entity.UserEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author asachan@app-scoop.com
 */
@Component
@Lazy
public class UserAdapter {

    public UserEntity adapt(final UserDto userDto) {
        Assert.notNull(userDto, Constant.ADAPTER_INPUT_VALIDATION);
        return UserEntity.builder().fullName(userDto.getFullName()).email(userDto.getEmail())
                .mobileNumber(userDto.getMobileNumber()).password(userDto.getPassword())
                .status(Constant.USER_STATUS_PENDING)
                .build();
    }

    public UserDto adapt(final UserEntity userEntity) {
        Assert.notNull(userEntity, Constant.ADAPTER_INPUT_VALIDATION);
        return UserDto.builder().id(userEntity.getId()).fullName(userEntity.getFullName()).email(userEntity.getEmail())
                .mobileNumber(userEntity.getMobileNumber()).password(userEntity.getPassword())
                .status(userEntity.getStatus()).build();
    }
}
