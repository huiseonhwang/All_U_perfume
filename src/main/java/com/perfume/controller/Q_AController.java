package com.perfume.controller;


import com.perfume.beans.BoardDTO;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Pagemaker;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;
import com.perfume.controller.NoticeController;
import com.perfume.service.NoticeBoardService;
import com.perfume.service.Q_ABoardService;
import com.perfume.service.RecommendationBoardService;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import oracle.net.aso.q;


@Controller
@Log4j
@Slf4j
@RequestMapping("perfume")
public class Q_AController {
	
	@Setter(onMethod_=@Autowired)
	private Q_ABoardService q_aservice;
	

	// Q_A 내용 보기 + 조뢰수 증가 + 페이징 처리
	@RequestMapping("q_a/q_aContent")
	public String content(Model model, RedirectAttributes rttr, BoardDTO boardDTO, int b_number) {
		model.addAttribute("boardDTO", q_aservice.q_aContent(boardDTO));
		q_aservice.q_areadcount(b_number);
		return "board/q_a/q_aContent";
	}
	
	// Q_A 글 작성 Form
	@RequestMapping("q_a/write")
	public String writeForm(Model model, BoardDTO boardDTO) {
		return "board/q_a/write";
	}
		
	// Q_A 글 작성 Pro
	@RequestMapping("q_a/writePro") 
	public String writePro(Model model, BoardDTO boardDTO) {
		model.addAttribute("result", q_aservice.q_ainsert(boardDTO));
		return "board/q_a/writePro";	
	}
	
	// Q_A 글 수정 Form
	
	@RequestMapping("q_a/update")
	public String updateForm(Model model, BoardDTO boardDTO) {
		model.addAttribute("boardDTO", q_aservice.q_aupdate(boardDTO));
		return "board/q_a/update";
	}
	
	// Q_A 글 수정 Pro
	@RequestMapping("q_a/updatePro")
	public String updatePro(Model model, BoardDTO boardDTO) {
		model.addAttribute("result", q_aservice.q_aupdate(boardDTO));
		return "board/q_a/updatePro";
	}
	
	// Q_A 글 삭제
	@RequestMapping("q_a/delete") 
	public String delete(Model model, BoardDTO boardDTO) {
		return "board/q_a/delete";
	}
	
	// Q_A 글 삭제
	@RequestMapping("q_a/deletePro") 
	public String deletePro(Model model, String b_number) {
		model.addAttribute("result", q_aservice.q_adelete(b_number));
		return "board/q_a/deletePro";
	}
	
	// Q_A 리스트 처리
	@RequestMapping("q_a/list")
	public String list(Model model, Paging pa, BoardDTO boardDTO, MemberDTO memberDTO, HttpSession session, SearchCriteria scri) {
		model.addAttribute("q_a_list",q_aservice.selectQ_aBoard(scri));
		session.setAttribute("id", memberDTO.getId());
		session.setAttribute("kid", memberDTO.getId());
		Pagemaker pagemaker = new Pagemaker(); // 객체생성
		pagemaker.setPa(pa);
		pagemaker.setTotalCount(q_aservice.countQ_aBoard(scri));
		model.addAttribute("pageMaker", pagemaker);
		return "board/q_a/q_aBoardPage";
	}
	
	// 게시글 선택 삭제
	@RequestMapping("q_a/delete_2")
	public @ResponseBody String noticedelete_2(HttpServletRequest request, String b_number,SearchCriteria scri) {
		String[] ajaxMsg = request.getParameterValues("valueArr");
		int size = ajaxMsg.length;
		for (int i=0; i<size; i++) {
			q_aservice.q_adelete(ajaxMsg[i]);
		}
		return "1";
	}
	
	@RequestMapping("q_a/re_write") 
	public String re_write(Model model) { 
		//원글의 정보를 답글 쓰기 화면에서 알 수 있도록 한다. 
		return "board/q_a/re_write"; 
		}
	
	@RequestMapping("q_a/re_writePro")
	public String writePro(BoardDTO boardDTO, HttpServletRequest request) {
		// boardDTO.setReg_date(boardDTO);
		int b_number = 0;
		int max = q_aservice.maxNum();
		if (max > 0) 
			b_number=max+1;
		else
			b_number=1; 
		if (boardDTO.getB_number() != 0) {
			q_aservice.stepUpdate(boardDTO);
			boardDTO.setRe_step(boardDTO.getRe_step()+1);
			boardDTO.setRe_level(boardDTO.getRe_level()+1);
		} else {
			boardDTO.setRef(b_number);
			boardDTO.setRe_level(0);
			boardDTO.setRe_step(0);
		}
		q_aservice.insertArticle(boardDTO);
		return "board/q_a/re_writePro";
	}
}
