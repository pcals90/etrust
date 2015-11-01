package co.com.etrust.etmoduleconfiguration.response.dto;

public class ETCurrentModules {

	private String moduleName;
	private String moduleDescription;
	private String moduleStatus;
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
	public String getModuleStatus() {
		return moduleStatus;
	}
	public void setModuleStatus(String moduleStatus) {
		this.moduleStatus = moduleStatus;
	}
	@Override
	public String toString() {
		return "ETCurrentModules [moduleName=" + moduleName + ", moduleDescription=" + moduleDescription
				+ ", moduleStatus=" + moduleStatus + "]";
	}
	
	
	
}
