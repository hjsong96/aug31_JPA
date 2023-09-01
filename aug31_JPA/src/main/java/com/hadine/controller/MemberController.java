package com.hadine.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hadine.entity.Member;
import com.hadine.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(Member member, HttpSession session) {
		//Member(mno=0, mname=null, mid=siggy, mpw=12345, mjoindate=null)
		System.out.println(member);
		
		int count = memberService.count(member);
		System.out.println("카운트 : " + count);
		
		if (count == 1) {
			Member result = memberService.findByMidAndMpw(member);
			System.out.println("name" + result);
			session.setAttribute("id", result.getMid());
			session.setAttribute("name", result.getMname());
			
			return "redirect:/index";
		} else {
			return "/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/index";
	}

}
