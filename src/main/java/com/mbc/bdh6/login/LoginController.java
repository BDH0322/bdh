package com.mbc.bdh6.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value="/login")
	public String w1() {
		
		return "login";
	}
	
	@RequestMapping(value="/logincheck") //로그인 화면에서 넘어온 자료 확인
	public String w2(LoginDTO dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id=dto.getId();
		String pw=dto.getPw();
		//로그인 아이디와 같은 패스워드를 db에서 가져올 것
		
		LoginService ls=sqlsession.getMapper(LoginService.class);
		String spw=ls.pwsearch(id); //id를 보낸다+pw를 찾는다=동일한 id를 가지고 있는 pw를 찾는다.
		
		PasswordEncoder pe=new BCryptPasswordEncoder();		
		boolean flag= pe.matches(pw, spw); //true false
		
		if(flag) //pw가 참이라면
		{
			HttpSession hs=request.getSession();
			hs.setAttribute("loginstate", true); //loginstate가 true이니
			hs.setAttribute("id", id); //pw와 같은 id를 찾아준다
			return "redirect:/"; //로그인에 성공했으니 메인으로 돌아간다
		}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pww=response.getWriter(); //pww는 비밀번호가 맞지 않았다는 상황의 변수이다.
			pww.print("<script>alert('아이디 또는 비밀번호 오류입니다.')</script>");
			pww.print("<script>location.href='login')</script>");
			pww.close(); //창을 닫는다
			return "redirect:/login"; //로그인 창으로 돌아간다
		}
	}
	
	@RequestMapping(value="/logout")
	public String w3(HttpServletRequest request) {
		HttpSession hs=request.getSession();
		hs.removeAttribute("loginstate");
		hs.removeAttribute("id");
		hs.setAttribute("loginstate", false);
		
		return "redirect:/";
	}
}
