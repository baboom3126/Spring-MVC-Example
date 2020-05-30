package com.example.demo3.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo3.app.repository.UserRepository;
import com.example.demo3.app.entity.UserEntity;
import com.example.demo3.app.model.UserBo;
import com.example.demo3.app.service.UserService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/user")
public class UserController {
	

	@Autowired
	private UserService userservice;
	
	@RequestMapping(method = RequestMethod.POST, value ="/{id}/{name}")
	@ResponseBody
	public ResponseEntity<?> setUser(HttpServletRequest request, 
			HttpServletResponse response, @PathVariable String id, @PathVariable String name) {
		
		
		Long longId = Long.parseLong(id);
		
		UserBo userbo = new UserBo();
		userbo.setId(longId);
		userbo.setName(name);
		userservice.add(userbo);
		
		
		try {
			UserBo QueryUserBo = userservice.get(longId);
		
			return new ResponseEntity<>(QueryUserBo,HttpStatus.OK);
		}
		catch(Exception e) {
			
			return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/all")
	@ResponseBody
	public ResponseEntity<?> getAllUser(HttpServletRequest request, 
			HttpServletResponse response){
		
		List<UserEntity> userlist = userservice.findAll();
		
		
		return new ResponseEntity<>(userlist,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/new/{newName}")
	@ResponseBody
	public ResponseEntity<?> setNewUserByName(HttpServletRequest request, 
	HttpServletResponse response, @PathVariable String newName){
		
		//////
		
		
		return null;
		
	}
	
	@RequestMapping(value="/list")
	public String userlistPage() {
		return "userlist";
	}
	
	@RequestMapping(value="/new")
	public String usernewPage() {
		return "usernew";
	}

}
