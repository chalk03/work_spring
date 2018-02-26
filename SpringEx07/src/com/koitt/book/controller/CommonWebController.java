package com.koitt.book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koitt.book.model.FileException;
import com.koitt.book.service.FileService;

@Controller
public class CommonWebController {

	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/download.do", method=RequestMethod.GET, params="filename")
	public void download(HttpServletRequest request, HttpServletResponse response, 
			String filename) {
		
		try {
			fileService.download(request, response, filename);
			
		} catch (FileException e) {
			System.out.println(e.getMessage());
		}
	}
}
