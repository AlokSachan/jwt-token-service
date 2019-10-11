package com.alok.jwttokenservice.repository;


import com.alok.jwttokenservice.entity.UserEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author asachan@app-scoop.com
 */

@Repository
@Lazy
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}