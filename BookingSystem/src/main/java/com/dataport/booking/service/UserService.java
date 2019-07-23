package com.dataport.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataport.booking.entity.User;
import com.dataport.booking.repository.UserRepositoryIF;

@Service
@Transactional(rollbackFor = Exception.class)//当发生异常时回滚
public class UserService {
	
	@Autowired
	UserRepositoryIF userRepositoryIF;
	
	public Page<User> findAll(Pageable pageable){
		return userRepositoryIF.findAll(pageable);
	}
	
}
