package com.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.WishDTO;
import com.perfume.service.MypageService;
import com.perfume.service.PerfumeService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j
@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	@Setter(onMethod_=@Autowired)
	private MypageService service;
	
	@Setter(onMethod_=@Autowired)
	private PerfumeService pservice;
	
	@RequestMapping("registration")
	public String registration(Model model , PerfumeDTO pdto , String writer) {
		service.wishInsert(pdto.getF_number(), writer);
		
		return "mypage/registration";
	}
	
	@RequestMapping("wish")
	public String wish(Model model , PerfumeDTO pdto) {
		model.addAttribute("p",pservice.getDetail(pdto));
		return "mypage/wish";
	}
}
