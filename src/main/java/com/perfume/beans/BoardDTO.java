package com.perfume.beans;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data // lombok 라이브러리 사용, 생성자/set/get/toString 자동생성
public class BoardDTO {
	private int boardnum; // 게시판 종류 공지사항 = 3
	private int b_number; // 게시물 번호
	private String writer;
	private String auth; // 회원 등급
	private String password;
	private String subject;
	private String content;
	private String filename;
	private Date reg_date; // 작성일 timestamp-sql전용, Date 다 가능
	private int readcount;
	private int b_like; // 좋아요 수
	
	/* 계층형 게시판을 위한 추가 필드 */
	private int ref; // 원글 게시글 번호(원글과 답글을 묶는 그룹 번호)
	private int re_step; // 그룹 내 순서, 자신의 글(답변글)에 있어서 원글이 누구인지에 대한 정보값, 
						 // 답변글이 아닌 원글일 경우 0을 가지도록 한다.
	private int re_level; // 들여쓰기 작업, 깊이를 나타내는 컬럼
					   // 답변글 쓰기에 있어 답변글이라면 원글의 depth +1 을 가지게 된다.
					   // 답변글이  아닌 원글ㅇ일 경우 0을 가지도록 한다.
	
}