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
	
	@RequestMapping(value="/logincheck") //�α��� ȭ�鿡�� �Ѿ�� �ڷ� Ȯ��
	public String w2(LoginDTO dto,HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id=dto.getId();
		String pw=dto.getPw();
		//�α��� ���̵�� ���� �н����带 db���� ������ ��
		
		LoginService ls=sqlsession.getMapper(LoginService.class);
		String spw=ls.pwsearch(id); //id�� ������+pw�� ã�´�=������ id�� ������ �ִ� pw�� ã�´�.
		
		PasswordEncoder pe=new BCryptPasswordEncoder();		
		boolean flag= pe.matches(pw, spw); //true false
		
		if(flag) //pw�� ���̶��
		{
			HttpSession hs=request.getSession();
			hs.setAttribute("loginstate", true); //loginstate�� true�̴�
			hs.setAttribute("id", id); //pw�� ���� id�� ã���ش�
			return "redirect:/"; //�α��ο� ���������� �������� ���ư���
		}
		else
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pww=response.getWriter(); //pww�� ��й�ȣ�� ���� �ʾҴٴ� ��Ȳ�� �����̴�.
			pww.print("<script>alert('���̵� �Ǵ� ��й�ȣ �����Դϴ�.')</script>");
			pww.print("<script>location.href='login')</script>");
			pww.close(); //â�� �ݴ´�
			return "redirect:/login"; //�α��� â���� ���ư���
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
