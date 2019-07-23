package com.dataport.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataport.booking.entity.User;

public interface UserRepositoryIF extends JpaRepository<User, String>{
	User findByAccount(String string);
}
