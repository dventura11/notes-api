package com.tenoch.presentation.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicViewController extends AbstractController{

	@RequestMapping(value="/")
	public String indexView(Model model){
		model.addAttribute("topics", topicMgr.getAllTopics());
		model.addAttribute("title", "WebPresentation");
		model.addAttribute("body", "public/inicio");
		return PUBLIC_TEMPLATE;
	}

	@RequestMapping(value="/view/{action}")
	public String publicView(@PathVariable String action, Model model){
		model.addAttribute("title", "WebPresentation");
		model.addAttribute("body", "public/" + action);
		return PUBLIC_TEMPLATE;
	}

	@RequestMapping(value="/view/topic/{topicId}")
	public String topicView(@PathVariable String topicId, Model model){
		model.addAttribute("topic", topicMgr.getTopic(topicId));
		model.addAttribute("title", "Topic Description");
		model.addAttribute("body", "public/topic");
		return PUBLIC_TEMPLATE;	
	}
	
}
