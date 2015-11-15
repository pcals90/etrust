package co.com.etrust.etmoduleconfiguration.response.dto;

import java.util.List;

public class ETRelationMetaData {
	
	private int moduleId;
	
	private List<ETMetaDataTable> tables;
	
	private List<ETFunctionalities> functionalities;
	
	public List<ETFunctionalities> getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(List<ETFunctionalities> functionalities) {
		this.functionalities = functionalities;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public List<ETMetaDataTable> getTables() {
		return tables;
	}

	public void setTables(List<ETMetaDataTable> tables) {
		this.tables = tables;
	}

	@Override
	public String toString() {
		return "ETRelationMetaData [moduleId=" + moduleId + ", tables=" + tables + ", functionalities="
				+ functionalities + "]";
	}

}
