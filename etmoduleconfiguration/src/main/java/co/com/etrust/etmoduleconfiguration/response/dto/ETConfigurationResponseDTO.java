package co.com.etrust.etmoduleconfiguration.response.dto;

public class ETConfigurationResponseDTO {
	
	private Object response;
	
	private String message;
	
	private ETResponseStatus status;

	public ETConfigurationResponseDTO(Object response, String message, ETResponseStatus status){
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

	public ETResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ETResponseStatus status) {
		this.status = status;
	}

	
	
	

}
