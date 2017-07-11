package com.intent.project.action;

public class WelcomeAction {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//all struts2 logic here
	public String execute() throws Exception {
		return "SUCCESS";
	}
	

}
