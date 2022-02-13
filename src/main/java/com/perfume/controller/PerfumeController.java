package com.perfume.controller;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfume.beans.FileInfo;
import com.perfume.beans.MemberDTO;
import com.perfume.beans.Pagemaker;
import com.perfume.beans.Paging;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.ReviewDTO;
import com.perfume.service.PerfumeService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Log4j
@Controller
@RequestMapping("/main/")
public class PerfumeController {
	
	@Autowired
	private PerfumeService service;
	
	@Autowired
	private FileInfo fileinfo;
	
	@RequestMapping("list")
	public String list(Model model, Paging pa) {
		model.addAttribute("list",service.listPage(pa));
		Pagemaker pagemaker = new Pagemaker();
		pagemaker.setPa(pa);
		pagemaker.setTotalCount(service.listCount());
		model.addAttribute("pa", pa);
		model.addAttribute("pageMaker", pagemaker);
		return "perfume/perfumePage";
	}
	
	@RequestMapping("search")
	public String search(Model model,PerfumeDTO dto, Paging pa, RedirectAttributes re, HttpServletRequest ht) { 
		String choose = dto.getChoose();
		String [] gender = dto.getC_gender();
		String [] season = dto.getC_season();
		if(choose != null && gender == null && season == null ) {
			model.addAttribute("keyword",service.keyword(dto, pa));
			Pagemaker pagemaker = new Pagemaker();
			pagemaker.setPa(pa);
			model.addAttribute("pageMaker",pagemaker);
			pagemaker.setTotalCount(service.keyCount(dto));
			model.addAttribute("pa", pa);
			
			return "perfume/perfumekPage";
		}
		else{ 
		model.addAttribute("cate",service.cate(dto,pa));		
		Pagemaker pagemaker = new Pagemaker();
		pagemaker.setPa(pa);
		model.addAttribute("pageMaker",pagemaker);
		pagemaker.setTotalCount(service.cateCount(dto));
		model.addAttribute("pa", pa);
		
		
		return "perfume/perfumePagePro";}
	}
	
	@RequestMapping("detail")
	public String detail(Model model, PerfumeDTO perfume, Paging pa, RedirectAttributes re, ReviewDTO rdto) {
	
		model.addAttribute("pa",pa);	
		model.addAttribute("getDetail",service.getDetail(perfume));
		
	
		
		List<PerfumeDTO> detail = service.getDetail(perfume);
		PerfumeDTO a = detail.get(0);
		model.addAttribute("brand",service.brand(a.getD_number()));

		
		String top = a.getTopnote_num();
	    String heart = a.getHeartnote_num();
	    String base = a.getBasenote_num();
	    
	    if( top != null) {
	        List<String> topnote = Arrays.asList(top.split("-"));
	        model.addAttribute("topnote",service.note(topnote));

	    }

	    if( heart != null) {
	        List<String> heartnote = Arrays.asList(heart.split("-"));
	        model.addAttribute("heartnote",service.note(heartnote));

	    }

	    if( base != null) {
	        List<String> basenote = Arrays.asList(base.split("-"));
	        model.addAttribute("basenote",service.note(basenote));
	    }
		
	    model.addAttribute("getReview",service.getReview(rdto));
	   
		return "perfume/perfumeDetail";
	
	}
	
	@RequestMapping("review")
	public String review(
	ReviewDTO rdto, PerfumeDTO perfume, RedirectAttributes re , HttpServletRequest req, MultipartFile file, Model model)  {
		service.reviewInsert(rdto);
//		 System.out.println("==========insert========================");
//		if(file != null) {
//			 System.out.println("==========if========================");
//			if(fileinfo.fileTypeCheck(file, "image")){
//				String orgName = file.getOriginalFilename(); 
//				String ext = orgName.substring(orgName.lastIndexOf(".")); 
//				String fileName = rdto.getWriter()+ext;  
//				String path = req.getSession().getServletContext().getRealPath("/resources/images/review"); 
//				File f = new File(path+"//"+fileName);
//				try {
//					file.transferTo(f);
//				} catch (Exception e) {
//					e.printStackTrace();
//				} 
//				
//				rdto.setFilename(fileName);
//				service.reviewImg(rdto);
//				System.out.println("==================================");
//			}
//		
//		
//		
//		}
				
		re.addAttribute("p_number",perfume.getP_number());
		re.addAttribute("f_name",perfume.getF_name());
		
		return "redirect:detail";
	}
	
	@RequestMapping("like")
	public String like(Model model,RedirectAttributes re, PerfumeDTO perfume, ReviewDTO rdto){
		System.out.println(rdto.getR_number()+"=========="+ rdto.getId());
		int chlike = service.chLike(rdto);
		System.out.println("========================"+chlike);
		if (chlike == 0){
			System.out.println("========================if");
			service.chInsert(rdto);
			System.out.println("========================insert");
			service.like(rdto);
			System.out.println("====================="+rdto.getR_number());
			System.out.println("========================like");
			}else {
				System.out.println("안됨");
			}
		re.addAttribute("p_number",perfume.getP_number());
		re.addAttribute("f_name",perfume.getF_name());
		
		return "redirect:detail";
	}
	
}
