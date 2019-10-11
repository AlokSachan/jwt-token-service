package com.alok.jwttokenservice.controller;

import com.alok.jwttokenservice.adapter.user.UserAdapter;
import com.alok.jwttokenservice.dto.UserDto;
import com.alok.jwttokenservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author asachan@app-scoop.com
 */

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor(
        onConstructor = @__({@Autowired, @Lazy}))
public class UserController {

    private final UserAdapter userAdapter;
    private final UserService userService;

    @PostMapping(
            value = "/register",
            produces = APPLICATION_JSON_UTF8_VALUE,
            consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDto> register(@RequestBody @Valid final UserDto userDto) {
        log.info("Received request to register user {}", userDto);
        return new ResponseEntity<>(userAdapter.adapt(userService.register(userAdapter.adapt(userDto))), CREATED);
    }

    @GetMapping(
            value = "/{userId}",
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDto> getUserById(@PathVariable final Long userId) {
        log.info("Request to get user id {} info", userId);
        return new ResponseEntity<>(userAdapter.adapt(userService.getUserById(userId)), OK);
    }

}
