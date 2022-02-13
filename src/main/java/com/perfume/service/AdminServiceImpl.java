package com.perfume.service;

import com.perfume.beans.AdminDTO;
import com.perfume.beans.BoardDTO;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Paging;
import com.perfume.mybatis.AdminMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Log4j
@Service
public class AdminServiceImpl implements AdminService{
	SqlSession sqlSession;

	@Setter(onMethod_=@Autowired)
	private AdminMapper mapper;

	@Override
	public int adminAdminLoginCheck(AdminDTO adminDTO) {
		return mapper.adminLoginCheck(adminDTO);
	}

	@Override
	public int member_delete(MemberDTO memberdto) {
		// sqlSession.delete("member_view", memberdto);
		return mapper.member_delete(memberdto);
	}

	@Override
	public int readcount(int b_number) {
		// TODO Auto-generated method stub
		return mapper.readcount(b_number);
	}

}
