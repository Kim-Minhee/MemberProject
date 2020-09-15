package com.hk.member.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hk.member.vo.Member;

@Repository
public interface MemberMapper {
	
	// CRUD 구현 ( Create, Read or Retrieve, Update, Delete )
	// 1. 전체 리스트
	// 2. 한 개만 보기
	// 3. 한 개만 insert
	// 4. 수정
	// 5. 삭제
	
	// 1. 전체 리스트
//	@Select("select * from members")
	public List<Member> memberList();

	// 2. 한 개만 보기
	// 3. 한 개만 insert
	// 4. 수정
	// 5. 삭제
	
}
