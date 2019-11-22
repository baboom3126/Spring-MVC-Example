package com.example.demo3.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.app.repository.UserRepository;
import com.example.demo3.app.entity.UserEntity;
import com.example.demo3.app.model.UserBo;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepository;
	
	public void add(UserBo bo) {
		
		UserEntity user = new UserEntity();
		user.setId(bo.getId());
		user.setName(bo.getName());
		userrepository.save(user);
	}
	
	public void save(UserEntity user) {
		userrepository.save(user);
	}
	
	
	public UserBo get(Long id) {
		
		UserEntity user = userrepository.findById(id).orElse(new UserEntity());
		UserBo bo = new UserBo();
		bo.setId(user.getId());
		bo.setName(user.getName());
		
		return bo;
	}
	
	public List<UserEntity> findAll(){
		return userrepository.findAll();
	}
	
}
