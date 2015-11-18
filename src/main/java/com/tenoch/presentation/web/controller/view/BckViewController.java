package com.tenoch.presentation.web.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenoch.presentation.internal.Article;
import com.tenoch.presentation.internal.SubTopic;
import com.tenoch.presentation.internal.Topic;

@Controller
public class BckViewController extends AbstractController{

	@RequestMapping(value="/bck/{action}")
	public String bckView(@PathVariable String action, Model model){
		model.addAttribute("title", action.toUpperCase());
		model.addAttribute("body", "bck/" + action);
		return BCK_TEMPLATE;
	}
	
	@RequestMapping(value="/bck/topics", method=RequestMethod.GET)
	public String showTopics(Model model){
		model.addAttribute("topics",topicMgr.getAllTopics());
		return bckView("topics", model);
	}
	
	@RequestMapping(value="/bck/topics", method=RequestMethod.POST)
	public String addTopic(Model model, @RequestParam String title, @RequestParam String description){
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setDescription(description);		
		topicMgr.insert(topic);
		model.addAttribute("topics",topicMgr.getAllTopics());
		return bckView("topics", model);
	}

	@RequestMapping(value="/bck/topic/{id}", method=RequestMethod.GET)
	public String getTopic(@PathVariable String id, Model model){
		model.addAttribute("topic",topicMgr.getTopic(id));
		return bckView("topic", model);
	}
	
	@RequestMapping(value="/bck/topic/{id}/remove", method=RequestMethod.POST)
	public String deleteTopic(@PathVariable String id, Model model){		
		topicMgr.delete(id);
		model.addAttribute("topics",topicMgr.getAllTopics());
		return bckView("topics", model);
	}

	@RequestMapping(value="/bck/topic/{id}/subTopic", method=RequestMethod.POST)
	public String addSubTopic(@PathVariable String id, @RequestParam String title, @RequestParam String html, Model model){
		SubTopic subTopic = new SubTopic();
		subTopic.setTitle(title);
		subTopic.setHtml(html);
		topicMgr.addSubTopic(id, subTopic);
		return getTopic(id, model);
	}

	@RequestMapping(value="/bck/topic/{id}/{subId}/**/update", method=RequestMethod.POST)
	public String updateSubTopic(@PathVariable String id, @PathVariable Long subId, @RequestParam String html, Model model){
		SubTopic subTopic = new SubTopic();
		subTopic.setHtml(html);
		subTopic.setId(subId);
		subTopic = topicMgr.updateSubTopic(id, subTopic);
		model.addAttribute("subTopic", subTopic);
		return bckView("subTopic", model);
	}

	@RequestMapping(value="/bck/topic/{id}/{subId}/delete", method=RequestMethod.POST)
	public String deleteSubTopic(@PathVariable String id, @PathVariable Long subId, Model model){
		SubTopic subTopic = new SubTopic();
		subTopic.setId(subId);
		subTopic = topicMgr.deleteSubTopic(id, subTopic);
		return getTopic(id, model);
	}
	
	@RequestMapping(value="/bck/topic/{id}/{idSub}", method=RequestMethod.GET)
	public String getSubTopic(@PathVariable String id,@PathVariable Long idSub, Model model){
		SubTopic subTopic = new SubTopic();
		subTopic.setId(idSub);
		model.addAttribute("subTopic", topicMgr.getSubTopic(id, subTopic));
		return bckView("subTopic", model);
	}
	
	@RequestMapping(value="/bck/topic/{id}/{idSub}/**/addArticle", method=RequestMethod.POST)
	public String addArticle(@PathVariable String id, @PathVariable Long idSub, @RequestParam String title, @RequestParam String html, Model model){
		Article article = new Article();
		article.setTitle(title);
		article.setHtml(html);		
		SubTopic subTopic = new SubTopic();
		subTopic.setId(idSub);
		topicMgr.addArticle(id, subTopic, article);
		return getSubTopic(id, idSub, model);
	}
}
