package org.sarb.java.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sarb.java.messanger.database.DatabaseClass;
import org.sarb.java.messanger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1l, new Message(1l, "Hello", "Sabjot"));
		messages.put(2l, new Message(2l, "Java", "Randhawa"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId((long) (messages.size() + 1));
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() < 0) {
			return null;
		} else {
			messages.put(message.getId(), message);
			return message;
		}
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}
