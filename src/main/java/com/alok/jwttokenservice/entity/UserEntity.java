package com.alok.jwttokenservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author asachan@app-scoop.com
 */

@Entity
@Table(
        name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder(
        toBuilder = true)
@Data
public class UserEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "FULL_NAME",
            nullable = false)
    private String fullName;

    @Column(
            name = "PASSWORD")
    private String password;

    @Column(
            name = "EMAIL",
            nullable = false)
    private String email;

    @Column(
            name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(
            name = "STATUS")
    private String status;

    @Column(name = "ENABLED")
    private boolean enabled;
//
//    @OneToOne(
//            fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
//    private RoleEntity role;
}
