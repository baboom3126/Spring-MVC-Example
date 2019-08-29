package com.example.demo3.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.app.entity.UserEntity;

@Repository
public interface UserDao extends CrudRepository<UserEntity,Long>{

}
