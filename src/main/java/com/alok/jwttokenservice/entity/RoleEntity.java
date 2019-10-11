package com.alok.jwttokenservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class RoleEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    private UserEntity user;
}
