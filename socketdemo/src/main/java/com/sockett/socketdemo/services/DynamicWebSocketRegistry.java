package com.sockett.socketdemo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Service
public class DynamicWebSocketRegistry {

	private final Map<String, WebSocketHandler> registryMap = new HashMap<>();
	
	public void registerHandler(String path, WebSocketHandler socketHandler) {
		this.registryMap.put(path, socketHandler);
	}
	public void registerHandlers(WebSocketHandlerRegistry registry) {
		registryMap.forEach((path, handler)->{
			registry.addHandler(handler, path).setAllowedOriginPatterns("*");
		});
	}
	
}
