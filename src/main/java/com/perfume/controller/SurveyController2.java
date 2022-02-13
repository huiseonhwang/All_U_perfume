package com.perfume.controller;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perfume.beans.AbsSurveyDTO;
import com.perfume.beans.FileInfo;
import com.perfume.beans.PerfumeDTO;
import com.perfume.beans.NoteDTO;
import com.perfume.service.PerfumeService;
import com.perfume.service.SurveyService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import oracle.net.ano.Service;

@Controller
@Slf4j
@Log4j
@RequestMapping("/survey2/")
public class SurveyController2 {
	
	@Autowired
	private SurveyService service;
	
	@Autowired
	private PerfumeService service2;
	
	@RequestMapping("surveyStart")
	public String surveyStart(){
		return "survey/surveyStart";
	}
	
	@RequestMapping("accSurvey")
	public String accSurvey(){
		return "survey/accSurvey";
	}
	
	@RequestMapping("accSurveyResult")
	public String accResult(NoteDTO ndto, Model model, String pageNum){
		//노트테이블에서 노트 번호 뽑아오기
		List<String> accList = service.SurveyNoteNumCheck(ndto);
		System.out.println(accList);
		//퍼퓸 테이블에 노트번호 넣어서 검색하기
		List<PerfumeDTO> perfumeList = service.SurveyAccNoteResult(accList);
		model.addAttribute("result",perfumeList);
		
		//브랜드 넘기기
	    List<String> brandNameList = new ArrayList();
	    for ( int i = 0 ; i< perfumeList.size() ; i++) {
	            PerfumeDTO a = perfumeList.get(i);
	            String aa = a.getD_number();
	            brandNameList.add(aa);
	      }
	     List<PerfumeDTO> brandName = service.SurveyBrandSearch(brandNameList);
	     model.addAttribute("brand",brandName);
		
	     
	     //페이징
	     int pageSize = 10;
	     if (pageNum == null) {
		        pageNum = "1";
		    }
	     int currentPage = Integer.parseInt(pageNum);
		 int startRow = (currentPage - 1) * pageSize + 1;
		 int endRow = currentPage * pageSize;
		 int count = 0;
		 count = service.SurveyGetPerfumeCount(accList);
		 List articleList = null;
		 if (count > 0) {
			 int accListSize = accList.size();
			 String[] n_number = accList.toArray(new String[accListSize]);
			articleList = service.SurveyGetPerfumes(n_number, startRow, endRow);
		 }
		 System.out.println(articleList.size());
		 
		 if (count > 0) {
		        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
				 
		        int startPage = (int)(currentPage/10)*10+1;
				int pageBlock=10;
		        int endPage = startPage + pageBlock-1;
		        if (endPage > pageCount) endPage = pageCount;
		        
		        // 밑의 if문, for문을 jsp 파일에서 작성하기 위해 연산 결과값을 model로 보냄
		        model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
		        model.addAttribute("pageCount", pageCount);
		 }
		 
		 model.addAttribute("pageNum", pageNum);
		 model.addAttribute("currentPage", currentPage);
		 model.addAttribute("startRow", startRow);
		 model.addAttribute("endRow", endRow);
		 model.addAttribute("count", count);
		 model.addAttribute("pageSize", pageSize);
		 model.addAttribute("articleList", articleList);
		 
		 int length = ndto.getNote_type_num().length;
		 
		 if(length == 1) {
			 model.addAttribute("noteTypeNum", ndto.getNote_type_num());
			 model.addAttribute("noteLength", length);
		 } else if(length == 2) {
			 String href = "";
			 for(String typeNum : ndto.getNote_type_num()) {
				 href += "&note_type_num=" + typeNum;
			 }
			 System.out.println(href);
			 model.addAttribute("url", href);
			 model.addAttribute("noteLength", length);
		 } else if(length == 3) {
			 String href = "";
			 for(String typeNum : ndto.getNote_type_num()) {
				 href += "&note_type_num=" + typeNum;
			 }
			 System.out.println(href);
			 model.addAttribute("url", href);
			 model.addAttribute("noteLength", length);
		 }
		 
		return "survey/accSurveyResult";
	}
	
	@RequestMapping("absSurvey")
	public String absSurvey(Model model, AbsSurveyDTO adto){
		model.addAttribute("first", service.SurveyAbsSurvey1()); 
		return "survey/absSurvey";
	}
	
	@RequestMapping("absSurvey2")
	public String absSurvey2(Model model, AbsSurveyDTO adto){
		model.addAttribute("second", service.SurveyAbsSurvey2());
		return "survey/absSurvey2";
	}
	
	@RequestMapping("absSurvey3")
	public String absSurvey3(Model model, AbsSurveyDTO adto){
		model.addAttribute("third", service.SurveyAbsSurvey3());
		return "survey/absSurvey3";
	}
	
	@RequestMapping("absSurvey4")
	public String absSurvey4(Model model, AbsSurveyDTO adto){
		model.addAttribute("fourth", service.SurveyAbsSurvey4(adto.getThird()));
		return "survey/absSurvey4";
	}
	
	@RequestMapping("absSurvey5")
	public String absSurvey5(Model model, AbsSurveyDTO adto){
		model.addAttribute("fifth", service.SurveyAbsSurvey5(adto.getFourth()));
		return "survey/absSurvey5";
	}
	
	@RequestMapping("absSurveyConfirm")
	public String absSurveyComfirm(Model model, AbsSurveyDTO adto){
		model.addAttribute("survey1",service.SurveyAbsSurveyResult1(adto.getGender())); 
		model.addAttribute("survey2",service.SurveyAbsSurveyResult2(adto.getSeason())); 
		model.addAttribute("survey3",service.SurveyAbsSurveyResult3(adto.getThird())); 
		model.addAttribute("survey4",service.SurveyAbsSurveyResult4(adto.getFourth())); 
		model.addAttribute("survey5",service.SurveyAbsSurveyResult5(adto.getFifth())); 
		return "survey/absSurveyConfirm";
	}
	
	@RequestMapping("absSurveyResult")
    public String absResult(Model model, AbsSurveyDTO adto , NoteDTO ndto , PerfumeDTO pdto, String pageNum) {
//        노트타입넘 가져오려고 설문 결과 노트를 가져와서 , 기준으로 자르고 리스크 만들었다! 
        String note = adto.getNote();
        System.out.println(note); //번호 날것이 , 찍혀서 나옴
        List<String> surveyNote = Arrays.asList(note.split(",")); 
//        위에서 만든 리스트 가지고 노트타입넘에 맞는 노트 넘버 긁어왔다!
        List<String> noteList = service.SurveyAbsNoteNumCheck(surveyNote);
//        이제 저게 들어간 향수를 검색할꺼다!
        List<PerfumeDTO> perfumeList = service.SurveyAbsNoteResult(noteList);
        model.addAttribute("result",perfumeList); 
        
//        브랜드 이름 가져오기 
        List<String> brandNameList = new ArrayList();
        for ( int i = 0 ; i< perfumeList.size() ; i++) {
            PerfumeDTO aaa = perfumeList.get(i);
            String aaaa = aaa.getD_number();
            brandNameList.add(aaaa);
        }
        List<PerfumeDTO> brandName = service.SurveyBrandSearch(brandNameList);
        model.addAttribute("brand",brandName);
        

        return "/survey/absSurveyResult";
    }
	
}
