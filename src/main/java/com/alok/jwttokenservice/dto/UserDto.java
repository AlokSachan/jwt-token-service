package com.alok.jwttokenservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author asachan@app-scoop.com
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto {

    private Long id;
    @NotEmpty(
            message = "full name should not be null")
    private String fullName;
    @NotEmpty(
            message = "password field should not be null")
    private String password;
    @NotEmpty(
            message = "email should not ne null")
    @Email(
            message = "Please enter valid email")
    private String email;
    private String mobileNumber;
    private String status;
}
