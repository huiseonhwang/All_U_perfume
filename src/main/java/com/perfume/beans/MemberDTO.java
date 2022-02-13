package com.perfume.beans;

import java.util.Date;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private Date birthday;
	private String birthday2; //형변환용
	private String gender;
	private Date regdate;
	private String auth;
	private String img;
	private String api_token;
}
