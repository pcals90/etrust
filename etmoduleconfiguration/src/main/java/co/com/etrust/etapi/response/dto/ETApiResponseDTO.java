package co.com.etrust.etapi.response.dto;

public class ETApiResponseDTO {
	
	private Object response;
	
	private String message;
	
	private ETApiResponseStatus status;

	public ETApiResponseDTO(Object response, String message, ETApiResponseStatus status){
		this.response = response;
		this.message = message;
		this.status = status;
	}
	
	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ETApiResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ETApiResponseStatus status) {
		this.status = status;
	}

	
	
	

}
