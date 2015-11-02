package co.com.etrust.etmoduleadministration.service;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleadministration.dao.connection.DBConfigurationReader;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleadministration.dao.moduleconfiguration.IModuleConfigurationDAO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

@Service("moduleMetadataService")
class ModuleMetadataService {
	
	@Autowired
	private IModuleConfigurationDAO configurationDAO;

	public boolean testConnection(String host, String dbName, String port, String user, String password,
			String dbProvider){
		
		ETDBConnectionManager.initSessionFactroy(host, dbName, port, user, password, dbProvider);
		
		return true;
	}

	public ETExistingInitialConfDTO readExistingConfFromFile() throws IOException, ConfigurationException{
		return DBConfigurationReader.readExistingConfFromFile();
	}

	public boolean saveNewInitialConfiguration(ETExistingInitialConfDTO conf) throws IOException, ConfigurationException{
		return DBConfigurationReader.saveNewInitialConfiguration(conf);
	}
	
}
