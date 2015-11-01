package co.com.etrust.etmoduleadministration.dao;

public interface IModuleConfigurationDAO {

	public boolean testConnection(String host, String dbName, String port, String user, String password,
			String dbProvider);

}
