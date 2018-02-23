package com.koitt.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koitt.board.service.UsersService;

@Controller
public class IndexWebController {

	@Autowired
	private UsersService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		
		// UsersService의 pricipal 객체를 가져와서 사용자 이메일값을 가져온다.
		UserDetails principal = service.getPrincipal();
		
		// 이메일값이 존재한다는 것은 로그인 된 상태
		if (principal != null) {
			model.addAttribute("isLogin", true);
		}
		// 그렇지 않다면 로그인이 되지 않은 상태
		else {
			model.addAttribute("isLogin", false);
		}
		
		return "index";
	}
}
