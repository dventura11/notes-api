package com.tenoch.presentation.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmViewController extends AbstractController{

	@RequestMapping(value="/adm/{action}")
	public String admView(@PathVariable String action, Model model){
		model.addAttribute("title", "WebPresentation");
		model.addAttribute("body", "adm/" + action);
		return ADM_TEMPLATE;
	}	
	
}
