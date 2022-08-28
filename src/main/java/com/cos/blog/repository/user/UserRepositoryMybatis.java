package com.cos.blog.repository.user;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserRepositoryMybatis {
	
	public int getAllMember();

	// ID 중복체크 AJAX용
	public int userDuplCheck(String userName);

	public String authorityNameFind(String role_code);
	
}
