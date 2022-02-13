package com.perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;
import com.perfume.mybatis.NoticeBoardMapper;

import lombok.Setter;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	@Setter(onMethod_=@Autowired)
	private NoticeBoardMapper noticemapeer;
	

	@Override
	public List<BoardDTO> getList() {
		// TODO Auto-generated method stub
		return noticemapeer.getList();
	}

	@Override
	public int noticeinsert(BoardDTO board) {
		// TODO Auto-generated method stub
		return noticemapeer.noticeinsert(board);
	}

	@Override
	public BoardDTO noticeContent(BoardDTO board) {
		// TODO Auto-generated method stub
		return noticemapeer.noticeContent(board);
	}

	@Override
	public int noticedelete(String b_number) {
		// TODO Auto-generated method stub
		return noticemapeer.noticedelete(b_number);
	}

	@Override
	public int noticeupdate(BoardDTO board) {
		// TODO Auto-generated method stub
		return noticemapeer.noticeupdate(board);
	}

	@Override
	public int readcount(int b_number) {
		// TODO Auto-generated method stub
		return noticemapeer.readcount(b_number);
	}

	@Override
	public int countNoticeBoard(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return noticemapeer.countNoticeBoard(scri);
	}

	@Override
	public List<BoardDTO> selectNoticeBoard(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return noticemapeer.selectNoticeBoard(scri);
	}


}
