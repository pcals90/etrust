package co.com.etrust.etmoduleadministration.service;

public interface IModuleService {

	public boolean testConnection(String host, String dbName, String port, String user, String password, String dbProvider);
	
}
