package com.tenoch.presentation.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicViewController {

	@RequestMapping(value="/")
	public String indexView(Model model){
		return "index.html";
	}

}
