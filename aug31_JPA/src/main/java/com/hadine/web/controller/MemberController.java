package com.hadine.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hadine.web.Member;
import com.hadine.web.repository.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/members")
	public String members(Model model) {
//		Member member = new Member();
//		member.setMid("pororo");
//		member.setMname("포로로");
//		member.setMpw("01234567");
//		member.setMjoindate("2023-08-31");
//		
//		memberRepository.save(member);
		
		//List<Member> list = memberRepository.findAll(); 전체뽑기
		List<Member> list = memberRepository.findTop5ByOrderByMno();
		//적어볼까요?
		/* findAll() 전체 가져오기
		 * findOne() 하나 가져오기, pk 기준
		 * save()    저장하기 / 수정하기
		 * count()
		 * delete()  
		 * 
		 */
		model.addAttribute("list", list);
		System.out.println(list);
		
		return "/members";
	}
	
}
