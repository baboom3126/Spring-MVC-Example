package com.example.demo3.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.app.dao.UserDao;
import com.example.demo3.app.entity.UserEntity;
import com.example.demo3.app.model.UserBo;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;
	
	public void add(UserBo bo) {
		
		UserEntity user = new UserEntity();
		user.setId(bo.getId());
		user.setName(bo.getName());
		userdao.save(user);
	}
	
	
	public UserBo get(Long id) {
		
		UserEntity user = userdao.findById(id).orElse(new UserEntity());
		UserBo bo = new UserBo();
		bo.setId(user.getId());
		bo.setName(user.getName());
		
		return bo;
	}
}
