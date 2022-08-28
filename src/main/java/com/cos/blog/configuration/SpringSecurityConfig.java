package com.cos.blog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.configuration.auth.PrincipalDetailService;


//@Configuration 설정
//@EnableWebSecurity - 시큐리티가 프로그램 로딩시 활성화

@Configuration //시큐리티 빈등록 어노테이션 : 스프링 컨테이너에서 관리할수 있게 해준다 IoC
@EnableWebSecurity //스프링시큐리티 필터가 스프링 필터체인에 등록이 됩니다 필터란 스프링시큐리티가 활성화 되어있지만 어떤설정을 해주겠다
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	//비밀번호 암호화 Bean
	//passwordEncoder 메서드
	@Bean
	public BCryptPasswordEncoder EncoderPwd() {
    return new BCryptPasswordEncoder();
	}
	
    //  참고 문헌 https://hooongs.tistory.com/233
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 로그인 처리를 하기 위한 AuthenticationManagerBuilder를 설정
        auth.userDetailsService(principalDetailService).passwordEncoder(EncoderPwd());
    }
	

	
	@Override
	public void configure(WebSecurity web) {
		// CSS등 에 대해 Spring Security FilterChain 제외
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.ignoring().antMatchers("/static/js/**", "/static/css/**", "/static/img/**", "/static/frontend/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()  // csrf 토큰 비활성화 (테스트시 걸어두는 게 좋음)
			.authorizeRequests()
				.antMatchers("/", "/main","/user/**", "/js/**", "/css/**", "/image/**", "/dummy/**") 
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/user/loginForm")
				.loginProcessingUrl("/user/loginProc")
				.defaultSuccessUrl("/"); // 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
	}
	
	

}