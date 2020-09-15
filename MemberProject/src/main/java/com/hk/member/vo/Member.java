package com.hk.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Member {

	// 필드
	int mno;
	String email;
	String mname;
	String pwd;
	Date cre_date;
	Date mod_date;
	
	// 3가지를 기본 생성해야 함
	// 1. getter
	// 2. setter
	// 3. toString
	
}
