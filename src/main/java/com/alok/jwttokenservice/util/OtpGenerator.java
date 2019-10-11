package com.alok.jwttokenservice.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author asachan@app-scoop.com
 */

@Component
public class OtpGenerator {

    private static final Random RANDOM = new Random();

    public String getOtp(final int randomNumDigits) {
        int base = 1;
        for (int i = 0; i < randomNumDigits - 1; i++) {
            base = base * 10;
        }
        final int max = base * 10 - 1 - base;
        return String.valueOf(base + RANDOM.nextInt(max));
    }
}
