package com.spring.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.entity.UserEntity;
import com.spring.demo.repository.UserRepository;
import com.spring.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		
		
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		Optional<UserEntity>  user = userRepository.findById(id);
		return user.get();
	}

	@Override
	public UserEntity save(UserEntity entity) {
		// TODO Auto-generated method stub
		
		return userRepository.save(entity);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

}
