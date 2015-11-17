package com.tenoch.presentation.web.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenoch.presentation.core.manager.topic.ITopicManager;

@Controller
public class ViewController {

	@Autowired
	private ITopicManager topicMgr;
	
	private static final String PUBLIC_TEMPLATE = "layout/publicTemplate";
	private static final String BCK_TEMPLATE = "layout/bckTemplate";
	private static final String ADM_TEMPLATE = "layout/admTemplate";

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

	@RequestMapping(value="/bck/{action}")
	public String bckView(@PathVariable String action, Model model){
		model.addAttribute("title", "WebPresentation");
		model.addAttribute("body", "bck/" + action);
		return BCK_TEMPLATE;
	}

	@RequestMapping(value="/adm/{action}")
	public String admView(@PathVariable String action, Model model){
		model.addAttribute("title", "WebPresentation");
		model.addAttribute("body", "adm/" + action);
		return ADM_TEMPLATE;
	}
	
	@RequestMapping(value="/view/topic/{topicId}")
	public String topicView(@PathVariable int topicId, Model model){
		model.addAttribute("topic", topicMgr.getTopic(topicId));
		model.addAttribute("title", "Topic Description");
		model.addAttribute("body", "public/topic");
		return PUBLIC_TEMPLATE;	
	}
	
}
