package org.sarb.java.messanger.model;

public class ErrorMessage {
	private String documentation;
	private int errorCode;
	private String description;

	public ErrorMessage(String documentation, int errorCode, String description) {
		super();
		this.documentation = documentation;
		this.errorCode = errorCode;
		this.description = description;
	}

	public ErrorMessage() {
		super();
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
