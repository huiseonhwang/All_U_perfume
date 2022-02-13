package com.perfume.controller;


import com.perfume.beans.AdminDTO;
import com.perfume.beans.BoardDTO;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Pagemaker;
import com.perfume.beans.Paging;
import com.perfume.beans.SearchCriteria;
import com.perfume.controller.NoticeController;
import com.perfume.service.NoticeBoardService;
import com.perfume.service.RecommendationBoardService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Controller
@Log4j
@Slf4j
@RequestMapping("perfume")
public class RecommendationController {
	
	@Setter(onMethod_=@Autowired)
	private RecommendationBoardService recommendationservice;
	
//	@RequestMapping("recommendation")
//	public String NoticeList(Model model) {
//		// http://localhost:8080/perfume/recommendation
//		log.info("향수 추천 목록 페이지 진입");
//		model.addAttribute("list", recommendationservice.getrecommendationList());
//		return "board/recommendation/recommendation";		
//	}

	// 추천 내용 보기 + 조뢰수 증가 + 페이징 처리
	@RequestMapping("recommendation/recommendationContent")
	public String content(Model model, RedirectAttributes rttr, BoardDTO boardDTO, int b_number, SearchCriteria scri) {
		model.addAttribute("boardDTO", recommendationservice.recommendaionContent(boardDTO));
		recommendationservice.countRecommendationBoard(scri);
		return "board/recommendation/recommendationContent";
	}
	
	// 추천 글 작성 Form
	@RequestMapping("recommendation/write")
	public String writeForm(Model model, BoardDTO boardDTO) {
		return "board/recommendation/write";
	}
		
	// 추천 글 작성 Pro
	@RequestMapping("recommendation/writePro") 
	public String writePro(Model model, BoardDTO boardDTO) {
		model.addAttribute("result", recommendationservice.recommendationinsert(boardDTO));
		return "board/recommendation/writePro";	
	}
	
	// 추천 글 수정 Form
	
	@RequestMapping("recommendation/update")
	public String updateForm(Model model, BoardDTO boardDTO) {
		model.addAttribute("boardDTO", recommendationservice.recommendaionContent(boardDTO));
		log.info("=======!!!+!+!+!+!+!+"+boardDTO.getSubject());
		// 값 자체가 안넘어감
		return "board/recommendation/update";
	}
	
	// 추천 글 수정 Pro
	@RequestMapping("recommendation/updatePro")
	public String updatePro(Model model, BoardDTO boardDTO) {
		model.addAttribute("result", recommendationservice.recommendationupdate(boardDTO));
		return "board/recommendation/updatePro";
	}
	
	// 추천 글 삭제
	@RequestMapping("recommendation/delete") 
	public String delete(Model model, BoardDTO boardDTO) {
		return "board/recommendation/delete";
	}
	
	// 추천 글 삭제
	@RequestMapping("recommendation/deletePro") 
	public String deletePro(Model model, int b_number) {
		model.addAttribute("result", recommendationservice.recommendationdelete(b_number));
		return "board/recommendation/deletePro";
	}
	
	// 페이징 처리
	
	@RequestMapping("recommendation/list")
	public String recommendation_list(Model model, Paging pa, BoardDTO boardDTO, MemberDTO memberDTO, HttpSession session, AdminDTO adminDTO, SearchCriteria scri) {
		model.addAttribute("recommendation_list",recommendationservice.selectRecommendationBoard(scri));
		// session.setAttribute("id", memberDTO.getId());
		// session.setAttribute("aid", adminDTO.getAid());
		// String id = (String)session.getAttribute("id");
		// String kid = (String)session.getAttribute("kid");
		// session.getAttribute("id");
		// log.info("향수 추천 jsp id세션 확인 =============== " + session.getAttribute("id"));
		Pagemaker pagemaker = new Pagemaker(); // 객체생성
		pagemaker.setPa(pa);
		pagemaker.setTotalCount(recommendationservice.countRecommendationBoard(scri));
		model.addAttribute("pageMaker", pagemaker);
		return "board/recommendation/recommendationBoardPage";
	}
	
	// 검색
//	@RequestMapping("recommendation/list")
//	public String recommendation_search(Model model, BoardDTO boardDTO) {
//		return "board/recommendation/recommendationBoardPage";
//	}

}
