package com.perfume.mybatis;

import org.apache.ibatis.annotations.Param;

import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.WishDTO;



public interface MypageMapper {
	
	public int wishRegister(@Param("f_number") String f_number , @Param("writer") String writer);
}
