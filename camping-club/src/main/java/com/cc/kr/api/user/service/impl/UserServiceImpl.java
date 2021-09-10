package com.cc.kr.api.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.kr.api.user.mapper.UserMapper;
import com.cc.kr.api.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	
	@Override
	public void getUser() {
		
		String name = userMapper.getUser();
		
		System.out.println(name);
//		System.out.println(count);
	}

}
