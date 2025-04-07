package com.mbc.bdh6.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value="/minput")
	public String q1() {
		
		return "minput";
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck2")
	public String q2(String id) {
		System.out.println("넘겨받은 아이디 : "+id);
		MemberService ms=sqlsession.getMapper(MemberService.class);
		
		int count=ms.idcount(id);
		String bigo=(count==1)?"no":"yes";
		
		return bigo;
	}
	
	@RequestMapping(value="/membersave")
	public String q3(MemberDTO dto) {
		
		String id=dto.getId();
		String pw=dto.getPw();
		String name=dto.getName();
		int age=dto.getAge();
		
		MemberService ms=sqlsession.getMapper(MemberService.class);
		
		PasswordEncoder pe=new BCryptPasswordEncoder();
		pw=pe.encode(pw);
		
		ms.insert(id,pw,name,age);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/mout")
	public String q4(Model mo, HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		HttpSession hs=request.getSession();
		boolean flag=(boolean)hs.getAttribute("loginstate");
		
		if(flag)
		{
		MemberService ms=sqlsession.getMapper(MemberService.class);
		ArrayList<MemberDTO> list=ms.select();
		mo.addAttribute("list",list);
		return "mout";
		}
		else 
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pww=response.getWriter();
			pww.print("<script>alert('로그인 해라')</script>");
			pww.print("<script>location.href='login')</script>");
			pww.close();
			ModelAndView mav=new ModelAndView();
			mav.setViewName("redirect:/");
			return "";
		}
	}
	
}
