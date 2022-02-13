package com.perfume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.WishDTO;
import com.perfume.mybatis.MypageMapper;
import com.perfume.mybatis.NoticeBoardMapper;

import lombok.Setter;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Setter(onMethod_=@Autowired)
	private MypageMapper mapper;

	@Override
	public int wishInsert(String f_number , String writer) {
		return mapper.wishRegister(f_number , writer);
	}
	
	

}
