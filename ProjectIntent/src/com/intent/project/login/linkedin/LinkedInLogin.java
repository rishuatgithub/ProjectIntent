package com.intent.project.login.linkedin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

/**
 * Linked in Login Page
 * @author Rishu
 *
 */
public class LinkedInLogin {
	
	// HTTP POST request
	public LinkedInProfile sendPost(String code ) throws Exception {

		String url = "https://www.linkedin.com/oauth/v2/accessToken";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "www.linkedin.com");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri="+LinkedInParameters.redirect_url+"&client_id="+LinkedInParameters.client_id+"&client_secret="+LinkedInParameters.client_secret+"";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
			
		JSONObject jsonObj = new JSONObject(response.toString());
		String access_token = jsonObj.getString("access_token");
		System.out.println(access_token);
			 
		LinkedInProfile obj_LinkedInProfile=new LinkedInProfile();
		obj_LinkedInProfile=sendGet(access_token);
			
		return obj_LinkedInProfile;

	}
	
private static LinkedInProfile sendGet(String access_token) throws Exception {
		
		LinkedInProfile obj_LinkedInProfile=new LinkedInProfile();
		

		String url = "https://api.linkedin.com/v1/people/~?format=json";

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection)obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("Host", "api.linkedin.com");
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Authorization", "Bearer "+	access_token);
		
		

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		JSONObject jsonObj = new JSONObject(response.toString());
		 
		obj_LinkedInProfile.setFirstName(jsonObj.getString("firstName"));
		obj_LinkedInProfile.setLastName(jsonObj.getString("lastName"));
		obj_LinkedInProfile.setHeadline(jsonObj.getString("headline"));
		obj_LinkedInProfile.setId(jsonObj.getString("id"));
		
		System.out.println(access_token);
		

		return obj_LinkedInProfile;
	}
	
}
