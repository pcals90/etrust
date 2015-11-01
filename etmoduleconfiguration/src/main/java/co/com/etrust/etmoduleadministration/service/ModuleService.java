package co.com.etrust.etmoduleadministration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
