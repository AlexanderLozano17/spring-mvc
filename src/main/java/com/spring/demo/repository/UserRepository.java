package com.spring.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

}
