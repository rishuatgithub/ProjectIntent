package com.intent.project.action;

import com.intent.project.login.linkedin.LinkedInParameters;

public class LoginAction {
	
	private String URL;
	
	public String execute() throws Exception {
		
		setURL(LinkedInParameters.linkedin_oauth+"?response_type=code&client_id="+LinkedInParameters.client_id+"&redirect_uri="+
				LinkedInParameters.redirect_url+"&scope="+LinkedInParameters.linkedin_scope
				);
		
		return "SUCCESS";
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

}
