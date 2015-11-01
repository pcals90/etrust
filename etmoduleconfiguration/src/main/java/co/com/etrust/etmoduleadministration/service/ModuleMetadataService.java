package co.com.etrust.etmoduleadministration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleadministration.dao.IModuleConfigurationDAO;

@Service("modulMetadataService")
class ModuleMetadataService {
	
	@Autowired
	private IModuleConfigurationDAO configurationDAO;

	public boolean testConnection(String host, String dbName, String port, String user, String password,
			String dbProvider){
		
		return configurationDAO.testConnection(host, dbName, port, user, password, dbProvider);
	}
	
}
