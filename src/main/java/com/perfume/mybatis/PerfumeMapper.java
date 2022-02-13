package com.perfume.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.perfume.beans.BrandDTO;
import com.perfume.beans.NoteDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.ReviewDTO;

public interface PerfumeMapper {
	
	//향수 상세페이지
	public List<PerfumeDTO> getDetail(PerfumeDTO perfume);  
	
	//게시물 갯수
	public int listCount(); 
	
	//페이징처리 포함한 리스트
	public List<PerfumeDTO> listPage(Paging pa);
	
	//성별, 계절 검색
	public List<PerfumeDTO> cate(@Param("c_gender") String[] gender, @Param("c_season") String[] season, 
			@Param("rowStart") int rowStart, @Param("rowEnd") int rowEnd);
	
	
	//키워드 검색
	public List<PerfumeDTO> keyword(@Param("keyword") String keyword, @Param("choose") String choose, 
			@Param("rowStart") int rowStart, @Param("rowEnd") int rowEnd) ; 
	
	
	 //검색후 게시물 갯수
	public int cateCount(@Param("c_gender") String[] c_gender, @Param("c_season") String[] c_season);
	
	//키워드 검색 후 게시물 갯수
	public int keyCount(@Param("keyword") String keyword, @Param("choose") String choose); 
	
	//브랜드별 검색
	public BrandDTO brandSearch(String d_number);
	
	//노트정보
	public List<NoteDTO> noteInfo(NoteDTO ndto);
	
	//리뷰입력
	public int reviewInsert(ReviewDTO rdto);
	
	//리뷰가져오기
	public List<ReviewDTO> getReview(ReviewDTO rdto);
	
	
	public int reviewImg(ReviewDTO rdto);
	
	public int chInsert(@Param("p_number") int p_number,
			@Param("r_number") int r_number,@Param("id") String id);
	
	public int chLike(ReviewDTO rdto);
	
	public int like(ReviewDTO rdto);

}
