package com.tenoch.presentation.web.controller.view;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BckViewController {

	@RequestMapping(value="/bck/{action}")
	public String bckView(@PathVariable String action){
		return "bck/" + action;
	}

}
