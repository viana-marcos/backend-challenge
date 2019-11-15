package com.invillia.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {
	
	private List<String> messages = new ArrayList<>();
	private Object data;
	
	public void addMessage(String message) {
		this.messages.add(message);
	}
	
	public void addAllMessages(List<String> messages) {
		this.messages.addAll(messages);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}	

}
