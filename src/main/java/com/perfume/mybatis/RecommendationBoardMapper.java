package com.perfume.mybatis;

import java.util.List;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;

public interface RecommendationBoardMapper {
	public List<BoardDTO> getrecommendationList(); // 게시판 글 목록 리턴할 메서드
	public int recommendationinsert(BoardDTO board); // 게시글 작성
	public BoardDTO recommendaionContent(BoardDTO board); // readcount
	public int recommendationdelete(int b_number); // 게시글 삭제
	public int recommendationupdate(BoardDTO board); // 게시글 업데이트
	public int readcount(int b_number); // 조회수 증가	
	// 게시글 총 갯수
	public int countRecommendationBoard(SearchCriteria scri);
	// 페이징 처리 게시글 조회
	public List<BoardDTO> selectRecommendationBoard(SearchCriteria scri);
}
