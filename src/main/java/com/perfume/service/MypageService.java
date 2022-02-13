package com.perfume.service;

import org.apache.ibatis.annotations.Param;

import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.WishDTO;

public interface MypageService {
	
	public int wishInsert(String f_number , String writer);

}
