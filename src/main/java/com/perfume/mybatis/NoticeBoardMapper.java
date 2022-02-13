package com.perfume.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.SearchCriteria;



public interface NoticeBoardMapper {
	
	// @Select("select * from tbl_board where boardnum='3' ")
	// 보통 위의 코드는 mapper.xml 파일에서 코드가 짜여지기 때문에 mapper.java 파일에는 쓰지 않는다.
	public List<BoardDTO> getList(); // 게시판 글 목록 리턴할 메서드
	
	public int noticeinsert(BoardDTO board);
	
	public BoardDTO noticeContent(BoardDTO board);
	
	public int noticedelete(String b_number);
	
	public int noticeupdate(BoardDTO board);
	
	public int readcount(int b_number);
	
	// 게시글 총 갯수
	public int countNoticeBoard(SearchCriteria scri);
	// 페이징 처리 게시글 조회
	public List<BoardDTO> selectNoticeBoard(SearchCriteria scri);
	

	
}