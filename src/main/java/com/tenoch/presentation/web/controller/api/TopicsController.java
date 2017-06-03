package com.tenoch.presentation.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.tenoch.presentation.core.manager.topic.ITopicManager;

@RestController
public class TopicsController {

	@Autowired
	private ITopicManager topicMgr;


}
