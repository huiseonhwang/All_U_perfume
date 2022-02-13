package com.perfume.mybatis;

import java.util.List;

import com.perfume.beans.AdminDTO;
import com.perfume.beans.BoardDTO;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Paging;


public interface AdminMapper {
	
	public int adminLoginCheck (AdminDTO adminDTO);
	
	// 관리자 회원 강제 탈퇴시 해당 회원이 있는지 체크하는 메서드
	public int member_delete(MemberDTO memberdto); 
	
	public int readcount(int b_number);
	
}
