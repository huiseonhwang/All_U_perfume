package com.perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;
import com.perfume.mybatis.NoticeBoardMapper;
import com.perfume.mybatis.RecommendationBoardMapper;

import lombok.Setter;

@Service
public class RecommendationBoardServiceImpl implements RecommendationBoardService {
	
	@Setter(onMethod_=@Autowired)
	private RecommendationBoardMapper recommendationmapper;
	
	@Override
	public List<BoardDTO> getrecommendationList() {
		// TODO Auto-generated method stub
		return recommendationmapper.getrecommendationList();
	}

	@Override
	public int recommendationinsert(BoardDTO board) {
		// TODO Auto-generated method stub
		return recommendationmapper.recommendationinsert(board);
	}

	@Override
	public BoardDTO recommendaionContent(BoardDTO board) {
		// TODO Auto-generated method stub
		return recommendationmapper.recommendaionContent(board);
	}

	@Override
	public int recommendationdelete(int b_number) {
		// TODO Auto-generated method stub
		return recommendationmapper.recommendationdelete(b_number);
	}

	@Override
	public int recommendationupdate(BoardDTO board) {
		// TODO Auto-generated method stub
		return recommendationmapper.recommendationupdate(board);
	}

	@Override
	public int readcount(int b_number) {
		// TODO Auto-generated method stub
		return recommendationmapper.readcount(b_number);
	}

	// 게시글 검색
	@Override
	public int countRecommendationBoard(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return recommendationmapper.countRecommendationBoard(scri);
	}
	
	// 검색 + 페이징 처리
	@Override
	public List<BoardDTO> selectRecommendationBoard(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return recommendationmapper.selectRecommendationBoard(scri);
	}
}
