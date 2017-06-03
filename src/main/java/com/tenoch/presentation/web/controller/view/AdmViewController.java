package com.tenoch.presentation.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmViewController {

	@RequestMapping(value="/adm/{action}")
	public String admView(@PathVariable String action, Model model){
		return "bck/" + action;
	}

}
