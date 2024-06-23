package com.sockett.socketdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sockett.socketdemo.dto.CreateTopic;

@RestController
@RequestMapping("/api")
public class ChatController {
	
	@Autowired
	private WebSocketController webSocketHandler;

	@RequestMapping(value="/createTopic", method=RequestMethod.POST)
	public String addTopic(@RequestBody CreateTopic topic) {
		// Register this topic dynamically
		webSocketHandler.addNewTopic("/"+topic.getTopicName());
		return "ok";
	}
}
