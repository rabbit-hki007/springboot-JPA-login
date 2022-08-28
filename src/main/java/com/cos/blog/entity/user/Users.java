package com.cos.blog.entity.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cos.blog.dto.user.UsersDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!!
//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
// @DynamicInsert // insert시에 null인 필드를 제외시켜준다.
public class Users {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment
	 
	@Column(nullable = false, length = 100) 
	private String username; // 아이디
	
	@Column(nullable = false, length = 200) // 123456 => 해쉬 (비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 2)
	private String role_code; // 권한코드
	
	@Column(nullable = true, length = 20)
	private String local_code; // 지역코드


	// @ColumnDefault("user")
	// DB는 RoleType이라는 게 없다.
	/*
	 * @Enumerated(EnumType.STRING) private RoleType role; // Enum을 쓰는게 좋다. //
	 * ADMIN, USER
	 */	
	
	//private String oauth; // kakao, google
	
	// 내가 직접 시간을 넣으려면 Timestamp.valueOf(LocalDateTime.now())
	@CreationTimestamp //insert시 자동을 값을 채워준다
	private Timestamp createdate;
	
	@UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private Timestamp updatedate;
	
	
	public void update(UsersDto usersDto) {
        this.password = usersDto.getPassword();
    }
	
}
