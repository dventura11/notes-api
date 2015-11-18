package com.tenoch.presentation.web.controller.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.tenoch.presentation.core.manager.topic.ITopicManager;

public abstract class AbstractController {

	@Autowired
	protected ITopicManager topicMgr;
	
	protected static final String PUBLIC_TEMPLATE = "layout/publicTemplate";
	protected static final String BCK_TEMPLATE = "layout/publicTemplate";
	protected static final String ADM_TEMPLATE = "layout/publicTemplate";

}
