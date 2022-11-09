package com.spring.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.demo.entity.UserEntity;
import com.spring.demo.repository.UserRepository;

@Service
public interface UserService{

	public List<UserEntity> findAll();
	
	public UserEntity findById(int id);
	
	public UserEntity save(UserEntity entity);
	
	public void deleteById(int id);
	
	
}
