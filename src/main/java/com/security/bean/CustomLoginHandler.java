package com.security.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j
public class CustomLoginHandler  implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		List<String> roleNames = new ArrayList<String>();
		
		// 사용자로그인시 권한정보를 받아온다. / 권한이 여러개설정된 사용자가 있을수도있다. 
		authentication.getAuthorities().forEach(authority ->{
			roleNames.add(authority.getAuthority());
			System.out.println("========role.authority==="+authority.getAuthority());
		});
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/security/admin");
			return ;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/security/member");
			return ;
		}
		response.sendRedirect("security/all");
		}
}

















