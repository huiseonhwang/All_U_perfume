package com.perfume.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.BrandDTO;
import com.perfume.beans.NoteDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.ReviewDTO;
import com.perfume.mybatis.PerfumeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j
@Service
public class PerfumeServiceImpl implements PerfumeService{
	
	@Setter(onMethod_=@Autowired)
	private PerfumeMapper mapper;

	@Override
	public List<PerfumeDTO> getDetail(PerfumeDTO perfume)  {
		return mapper.getDetail(perfume);
	}

	@Override
	public int listCount() {
		return mapper.listCount();
	}

	@Override
	public List<PerfumeDTO> listPage(Paging pa) {
		return mapper.listPage(pa);
		
	}

	@Override
	public List<PerfumeDTO> cate(PerfumeDTO perfume, Paging pa) {
		return mapper.cate(perfume.getC_gender(), perfume.getC_season(), pa.getRowStart(), pa.getRowEnd());
	}

	@Override
	public List<PerfumeDTO> keyword(PerfumeDTO perfume, Paging pa) {
		return mapper.keyword(perfume.getKeyword(), perfume.getChoose(), pa.getRowStart(), pa.getRowEnd());
	}

	@Override
	public int cateCount(PerfumeDTO perfume) {
		return mapper.cateCount(perfume.getC_gender(), perfume.getC_season());
}

	@Override
	public int keyCount(PerfumeDTO perfume) {
		return mapper.keyCount(perfume.getKeyword(), perfume.getChoose());
	}

	@Override
	public BrandDTO brand(String d_number) {
		return mapper.brandSearch(d_number);
	}

	@Override
	public List<NoteDTO> note(List<String> list) {
		List<NoteDTO> noteList = new ArrayList();
		NoteDTO ndto = new NoteDTO();
		for(int i = 0 ; i < list.size() ; i ++) {
			ndto.setN_number(list.get(i));
			noteList.addAll(mapper.noteInfo(ndto));
		}
		return noteList;
	}

	@Override
	public int reviewInsert(ReviewDTO rdto) {
		return mapper.reviewInsert(rdto);
	}

	@Override
	public List<ReviewDTO> getReview(ReviewDTO rdto) {
		return mapper.getReview(rdto);
	}

	@Override
	public int reviewImg(ReviewDTO rdto) {
		return mapper.reviewImg(rdto);
	}

	@Override
	public int chInsert(ReviewDTO rdto) {
		System.out.println("=====================serviceImplinsert");
		return mapper.chInsert(rdto.getP_number(),rdto.getR_number(),rdto.getId());
	}

	@Override
	public int chLike(ReviewDTO rdto) {
		System.out.println("=====================serviceImplchLike");
		return mapper.chLike(rdto);
	}

	@Override
	public int like(ReviewDTO rdto) {
		System.out.println("=====================serviceImplLike");
		return mapper.like(rdto);
	}
	
	
	


	
	

}
