package org.sarb.java.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.sarb.java.messanger.model.Message;
import org.sarb.java.messanger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
