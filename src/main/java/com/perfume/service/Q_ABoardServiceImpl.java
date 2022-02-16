package com.perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.BoardDTO;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;
import com.perfume.mybatis.Q_ABoardMapper;

import lombok.Setter;

@Service
public class Q_ABoardServiceImpl implements Q_ABoardService {
	
	@Setter(onMethod_=@Autowired)
	private Q_ABoardMapper qamapper;
	

	@Override
	public BoardDTO q_aContent(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.q_aContent(board);
	}

	@Override
	public int q_adelete(String b_number) {
		// TODO Auto-generated method stub
		return qamapper.q_adelete(b_number);
	}

	@Override
	public int q_aupdate(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.q_aupdate(board);
	}

	@Override
	public int countQ_aBoard(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return qamapper.countQ_aBoard(scri);
	}

	@Override
	public List<BoardDTO> selectQ_aBoard(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return qamapper.selectQ_aBoard(scri);
	}


	@Override
	public int q_areadcount(int b_number) {
		// TODO Auto-generated method stub
		return qamapper.q_areadcount(b_number);
	}

	@Override
	public int re_Q_a_Insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.re_Q_a_Insert(board);
	}

	@Override
	public BoardDTO getq_aBoardReInfo(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.getq_aBoardReInfo(board);
	}

	@Override
	public int updateQ_aReSeq(BoardDTO board) {
		// TODO Auto-generated method stub
		return qamapper.updateQ_aReSeq(board);
	}


	@Override
	public int q_amaxNum() {
		// TODO Auto-generated method stub
		return qamapper.q_amaxNum();
	}

	@Override
	public void q_astepUpdate(BoardDTO dto) {
		// TODO Auto-generated method stub
		qamapper.q_astepUpdate(dto);
	}

	@Override
	public int q_ainsert(BoardDTO dto) {
		// TODO Auto-generated method stub
		return qamapper.q_ainsert(dto);
	}


}
