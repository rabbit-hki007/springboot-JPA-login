package com.cos.blog.controller.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.user.ResponseDto;
import com.cos.blog.dto.user.UsersDto;
import com.cos.blog.service.user.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/user/joinProc")
	public ResponseDto<Integer> save(@RequestBody UsersDto usersDto) { // username, password, email
		System.out.println("UserApiController : save 호출됨");
		int result = userService.saveUser(usersDto);

		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)
	}

	@PutMapping("/user/updateProc")
	public ResponseDto<Integer> update(@RequestBody UsersDto usersDto) { // key=value, x-www-form-urlencoded
		
		userService.userUpdate(usersDto);
		// 여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음.
		// 하지만 세션값은 변경되지 않은 상태이기 때문에 우리가 직접 세션값을 변경해줄 것임.
		// 세션 등록

		//Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		//SecurityContextHolder.getContext().setAuthentication(authentication);
		//System.out.println("이것이 넘어온 값입니다 ->" + result);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PostMapping(value = "/user/idCheckProc")
	public String idDuplChk(@RequestParam ("username") String userName) throws Exception {
		
		System.out.println("넘어온 것" +  userName);
		
	    int result = userService.userDuplCheck(userName);
	    
	    
	    return String.valueOf(result);
	}

}

