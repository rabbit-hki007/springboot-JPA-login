package com.cos.blog.dto.user;

import com.cos.blog.entity.user.Users;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UsersDto {
	
	private int id;
	private String username;
	private String password;
	private String passwordConfirm;
	private String role_code;
	private String local_code;

	
	public Users toEntity() {
		Users build  = Users.builder()
				       .username(username)
				       .password(password)
				       .role_code(role_code)
				       .local_code(local_code)
				       .build();
		return build;
///////////////////////////////////////////////////////////////////////////////
//     패스워드를 빌드 하면서 넣어 줄수도 있다
//		Users build  = Users.builder()
//			       .username(username)
//			       .password(new BCryptPasswordEncoder().encode(password))
//			       .role_code(role_code)
//			       .local_code(local_code)
//			       .build();
//	    return build;
////////////////////////////////////////////////////////////////////////////////
	}

	
	@Builder
	public UsersDto(String username, String password, String role_code, String local_code) {
		this.username = username;
		this.password = password;
		this.role_code = role_code;
		this.local_code = local_code;
	}
	


}
