package com.susheel.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropsHelper {
//	private String username;
//	private String password;
//	private String url;
//	private String firstname;
//	private String lastname;
	
	Properties prop;
	
	public PropsHelper() throws IOException {
		prop = getPropsValue();
	}
	
	public String getUsername() {
		return prop.getProperty("username");
		
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
	public String getUrl() {
		return prop.getProperty("url");
	}
	public String getFirstname() {
		return prop.getProperty("firstname");
	}
	public String getLastname() {
		return prop.getProperty("lastname");
	}
	
	public String getBrowserName() {
		return prop.getProperty("browser");
	}
	
	public Properties getPropsValue() throws IOException {
		Properties p = new Properties();
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/testData.properties"));
		p.load(file);
		return p;
		
	}
}
