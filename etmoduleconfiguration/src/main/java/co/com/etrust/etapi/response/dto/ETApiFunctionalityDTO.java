package co.com.etrust.etapi.response.dto;

public class ETApiFunctionalityDTO {

	private String name;
	private String htmlElement;
	private String visualId;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVisualId() {
		return visualId;
	}
	public void setVisualId(String visualId) {
		this.visualId = visualId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHtmlElement() {
		return htmlElement;
	}
	public void setHtmlElement(String htmlElement) {
		this.htmlElement = htmlElement;
	}
	@Override
	public String toString() {
		return "ETApiFunctionalityDTO [name=" + name + ", htmlElement=" + htmlElement + ", visualId=" + visualId
				+ ", status=" + status + "]";
	}

	
}
