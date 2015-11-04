package co.com.etrust.etmoduleconfiguration.response.dto;

public class ETFunctionalities {

	private String name;
	private String status;
	private Integer id;
	private Integer moduleId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	@Override
	public String toString() {
		return "ETFunctionalities [name=" + name + ", status=" + status + ", id=" + id + ", moduleId=" + moduleId + "]";
	}
	
	
	
}
