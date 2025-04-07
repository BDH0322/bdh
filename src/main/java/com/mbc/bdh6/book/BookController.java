package com.mbc.bdh6.book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BookController {
	
	@Autowired
	SqlSession sqlSession;
	String path="C:\\MBC12AI\\spring\\day6\\src\\main\\webapp\\image";
	
	@RequestMapping(value="/binput")
	public String e1() {
		
		return "binput";
	}
	
	@RequestMapping(value="/booksave",method = RequestMethod.POST)
	public String e2(MultipartHttpServletRequest mul) throws IllegalStateException, IOException {
		
		String bname=mul.getParameter("bname");
		String bwriter=mul.getParameter("bwriter");
		String bmemo=mul.getParameter("bmemo");
		int bprice=Integer.parseInt(mul.getParameter("bprice"));
		MultipartFile mf=mul.getFile("bimage");
		String bdate=mul.getParameter("bdate");
		
		String fname=mf.getOriginalFilename();
		System.out.println("ÀúÀÚ¸í : "+bname);
		UUID ud=UUID.randomUUID();
		fname=ud.toString()+"_"+fname;
		mf.transferTo(new File(path+"\\"+fname));
		
		BookService bs=sqlSession.getMapper(BookService.class);
		bs.inserta(bname,bwriter,bmemo,bprice,fname,bdate);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/bout")
	public String e3(Model mo) {
		BookService bs=sqlSession.getMapper(BookService.class);
		ArrayList<BookDTO>list=bs.select();
		mo.addAttribute("list", list);
		
		return "bout";
	}
	
	@RequestMapping(value="bookdelete")
	public String e4(HttpServletRequest request, Model mo ) {
		
		int num=Integer.parseInt(request.getParameter("bnum"));
		BookService bs=sqlSession.getMapper(BookService.class);
		BookDTO dto=bs.delete(num);
		mo.addAttribute("dto", dto);
		
		return "bdelete";
	}
//	@RequestMapping(value="bookdelete2")
//	public String e5(MultipartHttpServletRequest mul, Model model){
//		int booknumber=Integer.parseInt(mul.getParameter("booknumber"));
//		String dfname=reque
//		
//		return "";
//	}
	
	
}
