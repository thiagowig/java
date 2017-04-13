package br.com.ithiago.crypt.challenger.model;

public class Response {

	private int status;
	
	private String content;
	
	public Response(int status, String content) {
		this.status = status;
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public String getContent() {
		return content;
	}

}
