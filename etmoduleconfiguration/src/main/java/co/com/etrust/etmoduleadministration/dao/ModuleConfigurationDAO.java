package co.com.etrust.etmoduleadministration.dao;

import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;

@Service("moduleConfigurationDAO")
public class ModuleConfigurationDAO implements IModuleConfigurationDAO {

	public boolean testConnection(String host, String dbName, String port, String user, String password,
			String dbProvider) {
		
		return ETDBConnectionManager.initSessionFactroy(host, dbName, port, user, password, dbProvider);
	}


}
