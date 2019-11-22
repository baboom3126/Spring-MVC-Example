package com.example.demo3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.app.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>,CrudRepository<UserEntity,Long>{

}
