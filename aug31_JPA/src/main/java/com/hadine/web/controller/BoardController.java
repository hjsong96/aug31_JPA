package com.hadine.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hadine.web.JBoard;
import com.hadine.web.repository.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;

	@GetMapping("/write")
	public String wirte() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String wirte(JBoard jBoard) {
		System.out.println(jBoard);
		//저장하기 save()
		jBoard.setMname("포로로");
		
		boardRepository.save(jBoard);
		
		return "redirect:/board";
	}
	
}
