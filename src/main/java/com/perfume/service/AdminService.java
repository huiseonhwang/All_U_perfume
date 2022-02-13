package com.perfume.service;

import java.util.List;

import com.perfume.beans.AdminDTO;
import com.perfume.beans.BoardDTO;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Paging;

public interface AdminService {
	// 관리자 로그인 시 유효성 검사
	public int adminAdminLoginCheck (AdminDTO adminDTO);
	
	// 관리자 회원 강제 탈퇴
	public int member_delete(MemberDTO memberdto); 
	
	public int readcount(int b_number); // 조회수 증가

}