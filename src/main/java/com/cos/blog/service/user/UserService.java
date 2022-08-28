package com.cos.blog.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.user.UsersDto;
import com.cos.blog.entity.user.Users;
import com.cos.blog.repository.user.UserRepository;
import com.cos.blog.repository.user.UserRepositoryMybatis;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepositoryMybatis userRepositoryMybatis;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public Users 회원찾기(String username) {
		Users users = userRepository.findByUsername(username).orElseGet(()->{
			return new Users();
		});
		return users;
	}
	
	@Transactional
	public int saveUser(UsersDto usersDto) {
		//////////////////////////////////////////////////////////////////////
	    // 여기는 entity로만 동작할때의 코드입니다 //
		//public int saveUser(Users users) {
		//String rawPassword = users.getPassword(); // 패스워드 원문 1111
		//String encPassword = encoder.encode(rawPassword); // 인코딩 패스워드
		//users.setPassword(encPassword);
		//users.setRole_code("30");
		///////////////////////////////////////////////////////////////////////
		
		String rawPassword = usersDto.getPassword(); // 패스워드 원문 1111
		String encPassword = encoder.encode(rawPassword); // 인코딩 패스워드
		usersDto.setPassword(encPassword);
		usersDto.setRole_code("30");
		try {
			//userRepository.save(users);
			userRepository.save(usersDto.toEntity()).getUsername();
			return 1;
		} catch (Exception e) {
			return -1;
		}
		
	}

	@Transactional
	public void userUpdate(UsersDto usersDto) {

			
			Users persistance = userRepository.findById(usersDto.getId()).orElseThrow(()->{
				return new IllegalArgumentException("회원 찾기 실패");
			});
			
			String rawPassword = usersDto.getPassword();
			String encPassword = encoder.encode(rawPassword);
			usersDto.setPassword(encPassword);
			persistance.update(usersDto);

		
	}

	public int userDuplCheck(String userName) {
		// TODO Auto-generated method stub
		return userRepositoryMybatis.userDuplCheck(userName);
	}

	public String authorityNameFind(String role_code) {
		// TODO Auto-generated method stub
		return userRepositoryMybatis.authorityNameFind(role_code);
	}
}
