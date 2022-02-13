package com.perfume.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;

@Component

public interface Q_ABoardService {
	public int q_ainsert(BoardDTO board); // 게시글 작성
	public BoardDTO q_aContent(BoardDTO board); // readcount
	public int q_adelete(String b_number); // 게시글 삭제
	public int q_aupdate(BoardDTO board); // 게시글 업데이트
	public int q_areadcount(int b_number); // 조회수 증가
	// 게시글 총 갯수
	public int countQ_aBoard(SearchCriteria scri);
	
	// 페이징 처리 게시글 목록
	public List<BoardDTO> selectQ_aBoard(SearchCriteria scri);
	
	// 답글 등록
	public int re_Q_a_Insert(BoardDTO board);
	
	// 답글 정보 조회
	public BoardDTO getq_aBoardReInfo(BoardDTO board);
	
	// 답글 순서
	public int updateQ_aReSeq(BoardDTO board);
	
	public int maxNum();
	public void stepUpdate(BoardDTO dto);
	public void insertArticle(BoardDTO dto);

}
