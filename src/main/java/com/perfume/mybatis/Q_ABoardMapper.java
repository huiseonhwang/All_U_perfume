package com.perfume.mybatis;

import java.util.List;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;


public interface Q_ABoardMapper {
	public BoardDTO q_aContent(BoardDTO board);
	
	public int q_adelete(String b_number);
	
	public int q_aupdate(BoardDTO board);
	
	public int q_areadcount(int b_number);
	
	// 게시글 총 갯수
	public int countQ_aBoard(SearchCriteria scri);
	
	// 페이징 처리 게시글 조회
	public List<BoardDTO> selectQ_aBoard(SearchCriteria scri);
	
	// 게시글 답글
	public int re_Q_a_Insert(BoardDTO board); 

	
	// 답글 정보 조회
	public BoardDTO getq_aBoardReInfo(BoardDTO board);
	
	// 답글 순서
	public int updateQ_aReSeq(BoardDTO board);
	
	
	public int q_amaxNum();
	public void q_astepUpdate(BoardDTO dto);
	public int q_ainsert(BoardDTO dto);
	
}
