package com.sockett.socketdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sockett.socketdemo.configuration.SocketConnectionHandler;
import com.sockett.socketdemo.services.DynamicWebSocketRegistry;

@Controller
public class WebSocketController {
	
	@Autowired
	private DynamicWebSocketRegistry dynamicWebSocketRegistry;
	
	public void addNewTopic(String path) {
		// you can even create a anonymous class
		/*
		 * WebSocketHandler webSocketHandler = new TextWebSocketHandler() {
		 * 			@Override stuff here
		 * 
		 * }
		 * */
		dynamicWebSocketRegistry.registerHandler(path, new SocketConnectionHandler());
	}
}
