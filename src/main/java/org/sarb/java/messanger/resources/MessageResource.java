package org.sarb.java.messanger.resources;

import java.util.List;

import org.sarb.java.messanger.model.Message;
import org.sarb.java.messanger.model.Profile;
import org.sarb.java.messanger.service.CommentService;
import org.sarb.java.messanger.service.MessageService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {

		if (filterBean.getYear() > 0) {
			return messageService.getAllMessages(filterBean.getYear());
		}

		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessages(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "Profile");
		message.addLink(getUriForComments(uriInfo, message), "Comments");
		return message;
	}

	private String getUriForComments(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource").path(CommentResource.class)
				.resolveTemplate("messageId", message.getId()).build().toString();
		return uri;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).build()
				.toString();
		return uri;

	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(message.getId()))
				.build().toString();
		return uri;
	}

	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
