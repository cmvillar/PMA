package com.adaptionsoft.games.trivia.messages;

import java.io.IOException;
import java.util.Properties;


public class MessageManager {
	private static MessageManager instance = null;
	private static Properties properties = new Properties();
	
	protected MessageManager(){
		try {
			properties.load(MessageManager.class.getResourceAsStream("mensajes_param.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MessageManager getInstance(){
		if(instance ==null)
			instance = new MessageManager();
		return instance;
	}
	
	public String getValue(String key){
		return properties.getProperty(key);
	}

}