package co.com.etrust.etapi.response.dto;

import java.util.List;

public class ETApiModuleDTO {
	
	private String moduleName;
	private String moduleDescription;
	private String serviceName;
	
	private List<ETApiFunctionalityDTO> functionalities;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public List<ETApiFunctionalityDTO> getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(List<ETApiFunctionalityDTO> functionalities) {
		this.functionalities = functionalities;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "ETApiModuleDTO [moduleName=" + moduleName + ", moduleDescription=" + moduleDescription
				+ ", functionalities=" + functionalities + "]";
	}
	
	

}
