package co.com.etrust.etmoduleadministration.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;

import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

public interface IModuleService {

	public boolean testConnection(String host, String dbName, String port, String user, String password, String dbProvider);

	public List<ETCurrentModules> getCurrentModules()throws ConfigurationException, IOException;

	public boolean activateModule(Integer moduleId) throws ConfigurationException, IOException;

	public boolean deactivateModule(Integer moduleId)throws ConfigurationException, IOException;

	public ETExistingInitialConfDTO readExistingConfFromFile()  throws ConfigurationException, IOException;

	public boolean saveNewInitialConfiguration(ETExistingInitialConfDTO conf)  throws ConfigurationException, IOException;

	public List<ETCurrentModules> getActiveModules() throws ConfigurationException, IOException;
	
}
