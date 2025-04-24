package com.Trading.Trading.Repository;

import com.Trading.Trading.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface UserRespository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);

//    Optional<UserEntity> findByEmail(UserEntity user);
}
