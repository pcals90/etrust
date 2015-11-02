package co.com.etrust.etmoduleadministration.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

@Service("moduleService")
public class ModuleService implements IModuleService{

	@Autowired
	private ModuleDirectoryService directoryService;
	
	@Autowired
	private ModuleAvailabilityService availabilityService;
	
	@Autowired
	private ModuleMetadataService metadataService;
	
	public boolean testConnection(String host, String dbName, String port, String user, String password,
			String dbProvider) {
		
		return metadataService.testConnection(host, dbName, port, user, password, dbProvider);
	}

	@Override
	public List<ETCurrentModules> getCurrentModules() throws ConfigurationException, IOException {
		return availabilityService.getCurrentModules(readExistingConfFromFile());
	}

	@Override
	public boolean activateModule(Integer moduleId) throws ConfigurationException, IOException {
		return availabilityService.activateModule(moduleId,readExistingConfFromFile());
	}

	@Override
	public boolean deactivateModule(Integer moduleId) throws ConfigurationException, IOException {
		return availabilityService.deactivateModule(moduleId,readExistingConfFromFile());
	}

	@Override
	public ETExistingInitialConfDTO readExistingConfFromFile() throws ConfigurationException, IOException {
		return metadataService.readExistingConfFromFile();
	}

	@Override
	public boolean saveNewInitialConfiguration(ETExistingInitialConfDTO conf) throws ConfigurationException, IOException {
		return  metadataService.saveNewInitialConfiguration(conf);
	}

	@Override
	public List<ETCurrentModules> getActiveModules() throws ConfigurationException, IOException {
		return availabilityService.getActiveModules(readExistingConfFromFile());
	}

}
