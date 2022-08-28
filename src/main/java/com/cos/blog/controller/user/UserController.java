package com.cos.blog.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
// 그냥 주소가 / 이면 index.jsp 허용
// static이하에 있는 /js/**, /css/**, /image/**

@Controller
public class UserController {

//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private UserService userService;
	
	////////// 로그인 관련 ///////////////
	@GetMapping("/user/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	//////////////////////////////////
	
	////////////회원가입 관련 ///////////
	
	@GetMapping("/user/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
//	@PostMapping(value = "/user/idCheckProc")
//	public @ResponseBody String idDuplChk(@RequestParam ("username") String userName) throws Exception {
//		
//		System.out.println("넘어온 것" +  userName);
//		
//	    int result = userService.userDuplCheck(userName);
//	    
//	    return String.valueOf(result);
//	}
	
	
	////////////////////////////////////////////
	
	
	/////////회원 수정 관련 //////////////////////
	
	@GetMapping("/user/updateForm")
	public String updateForm() {	
	  return "user/updateForm";
	}
	
	
}