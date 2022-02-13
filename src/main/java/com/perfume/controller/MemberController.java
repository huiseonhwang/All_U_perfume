package com.perfume.controller;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.perfume.beans.FileInfo;
import com.perfume.beans.MemberDTO;
import com.perfume.service.MemberService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Log4j
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService service; 
	
	@Autowired
	private FileInfo fileinfo;
		
	
	@RequestMapping("main")
	public String main() {
		return "member/main";
	}
		
	@RequestMapping("register")
	public String register() {
		return "member/register";
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@RequestMapping("registerPro")
	public String registerPro(MemberDTO dto, MultipartFile file, Model model, HttpServletRequest req) throws ParseException {
		
		//date타입 형변환 해서 저장하기.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dto.setBirthday(sdf.parse(dto.getBirthday2()));
		
		model.addAttribute("result", service.memberRegister(dto));
		
		if(file != null) {
			if(fileinfo.fileTypeCheck(file, "image")){
				String orgName = file.getOriginalFilename(); 
				String ext = orgName.substring(orgName.lastIndexOf(".")); 
				String fileName = dto.getId()+ext;  
				String path = req.getSession().getServletContext().getRealPath("/resources/images/img"); 
				File f = new File(path+"//"+fileName);
				try {
					file.transferTo(f);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				dto.setImg(fileName);
				service.memberImgUpdate(dto);
			}
		model.addAttribute("id",dto.getId());
		}
		return "member/registerPro";
	}
	
	@RequestMapping("idCheck")
	public @ResponseBody int idCheck(String id) {
		return service.memberIdCheck(id);
	}
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
		
	@RequestMapping("loginPro")
	public String loginPro(MemberDTO dto, HttpSession session) {
		if(service.memberLoginCheck(dto) == 1) {
			session.setAttribute("id", dto.getId());
		}
		return "member/loginPro";
	}
		
	@RequestMapping("kakaoCheck")
	public @ResponseBody int check(@RequestBody MemberDTO dto, HttpSession session) {
		
		int result = 0;
		
		if(service.memberIdCheck(dto.getId()) == 1) {
			result = 1;
		} else {
			result = service.memberKakaoRegister(dto);
		}
		
		session.setAttribute("kid", dto.getId());
		return result;
	}
	
	@RequestMapping("tokenCheck")
	public @ResponseBody String tokenCheck(@RequestBody MemberDTO dto, HttpSession session) {
		
		session.setAttribute("token", dto.getApi_token());
		if(dto != null) {
			dto.setApi_token("K_Token");
			log.warn(dto.getApi_token());
		}
		return dto.getApi_token();
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("kLogout")
	public @ResponseBody String kLogout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}
	
	@RequestMapping("userInfo")
	public String userInfo(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		String kid = (String)session.getAttribute("kid");
		
		if(id != null) {
			model.addAttribute("MemberDTO", service.memberUserInfo(id));
		} else if(kid != null) {
			model.addAttribute("MemberDTO", service.memberUserInfo(kid));
		}
		
		
		return "member/userInfo";
	}
		
	@RequestMapping("imgUpdate")
	public String imgUpdate() {
		return "member/imgUpdate";
	}
		
	@RequestMapping("imgUpdatePro")
	public String imgUpdatePro(MemberDTO dto, MultipartFile file, Model model, HttpServletRequest req) {
		if(file != null) {
			if(fileinfo.fileTypeCheck(file, "image")){
				String orgName = file.getOriginalFilename(); 
				String ext = orgName.substring(orgName.lastIndexOf(".")); 
				String fileName = dto.getId()+ext;  
				String path = req.getSession().getServletContext().getRealPath("/resources/images/img"); 
				File f = new File(path+"//"+fileName);
				try {
					file.transferTo(f);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				dto.setImg(fileName);
				service.memberImgUpdate(dto);
			}
		}
		return "member/imgUpdatePro";
	}
	
	@RequestMapping("pwCheck")
	public String pwCheck() {
		return "member/pwCheck";
	}
	
	@RequestMapping("pwCheckPro")
	public @ResponseBody int pwCheckPro(MemberDTO dto, String pw2) {
		log.info(""+dto);
		int result = 0;
		String dbpw = service.memberPwCheck(dto.getId());
		if(dto.getPw().equals(dbpw)) {
			dto.setPw(pw2);
			result = service.memberPwUpdate(dto);
		}
		return result;
	}
	
	
	@RequestMapping("pwUpdate")
	public String pwUpdate(MemberDTO dto) {
		return "member/pwUpdate";
	}
	
	@RequestMapping("delete")
	public String delete() {
		return "member/delete";	
	}
	
	@RequestMapping("deletePro")
	public String deletePro(MemberDTO dto, Model model, HttpSession session) {
		int result = service.memberLoginCheck(dto);
		if(result == 1) {
			result = service.memberTmpDelete(dto.getId());
			session.invalidate();
		}
		model.addAttribute("result", result);
		return "member/deletePro";
	}
	
	@RequestMapping("kakaoDeletePro")
	public @ResponseBody int kakaoDeletePro(@RequestBody MemberDTO dto, HttpSession session) {
		log.warn("kakaoDeletePro // "+dto);
		int result = 0;
		int check = service.memberKLoginCheck(dto);
		if(check == 1) {
			result = service.memberKakaoDelete(dto);
			session.invalidate();
		}
		return result;
	}
	
}
