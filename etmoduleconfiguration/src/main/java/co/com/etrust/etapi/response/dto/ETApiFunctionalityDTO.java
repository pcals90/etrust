package co.com.etrust.etapi.response.dto;

public class ETApiFunctionalityDTO {

	private String name;
	private String htmlElement;
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
		return "ETApiFunctionalityDTO [name=" + name + ", htmlElement=" + htmlElement + "]";
	}

	
}
