package com.cos.blog.configuration.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.entity.user.Users;
import com.cos.blog.service.user.UserService;

import lombok.Data;


//  스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
@Data
public class PrincipalDetail implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Users users; // 콤포지션
	
	
	@Autowired
	private UserService userService;
	
	
	public PrincipalDetail(Users users) {
		this.users = users;
	}
	
	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	// 계정이 만료되지 않았는지 리턴한다. (true: 만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있지 않았는지 리턴한다. (true: 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는지 리턴한다. (true: 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용가능)인지 리턴한다. (true: 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// 계정이 갖고있는 권한 목록을 리턴한다. (권한이 여러개 있을 수 있어서 루프를 돌아야 하는데 우리는 한개만)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		
		
		collectors.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				
				//권한을 얻어서 리턴
				String authority = "";
				String authority_code = users.getRole_code();
				
				//이건 왜 안될까? 된장할 ==> 안된다 이방법은 .....
				//String role_name = userService.authorityNameFind(authority_code);
				//System.out.println("이것이 진상인디 authority==>" + role_name);
				
				
			    System.out.println("String authority_code ==>" + users.getRole_code());
			
				if(authority_code.equals("10")){
					authority = "ROLE_ADMIN";
				} else if (authority_code.equals("20")){
					authority = "ROLE_MANAGER";
				} else if (authority_code.equals("30")){
					authority = "ROLE_USER";
				}
				System.out.println("String authority ==>" + authority);
				
				return authority;
			}
		});
		
		return collectors;
	}
	
}
