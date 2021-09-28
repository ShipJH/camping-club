package com.cc.kr.api.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	@Select("SELECT id FROM member LIMIT 1")
	String getUser();

	
}
