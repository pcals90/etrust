package co.com.etrust.etmoduleconfiguration.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleadministration.service.IModuleService;
import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETFunctionalities;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataColumn;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataTable;
import co.com.etrust.etmoduleconfiguration.response.dto.ETRelationMetaData;

@Service("initialConfService")
public class ETInitialConfigurationService {
	
	@Autowired
	private IModuleService moduleService;
	
	public boolean testConnection(String host, String port, String schema, String user, String password,
			String dbProvider) {

		
		return moduleService.testConnection(host, schema, port, user, password, dbProvider);

	}

	public ETExistingInitialConfDTO getExistingConfiguration() throws IOException, ConfigurationException {

		return moduleService.readExistingConfFromFile();
	}

	public boolean saveNewInitialConfiguration(ETExistingInitialConfDTO conf) throws IOException, ConfigurationException{

		return moduleService.saveNewInitialConfiguration(conf);
	}

	public List<ETCurrentModules> getCurrentModules() throws ConfigurationException, IOException {
		
		return moduleService.getCurrentModules();

	}

	public boolean activateModule(Integer moduleId) throws ConfigurationException, IOException {
		
		return moduleService.activateModule(moduleId);
	}

	public boolean deactivateModule(Integer moduleId) throws ConfigurationException, IOException {
		
		return moduleService.deactivateModule(moduleId);
	}

	public List<ETCurrentModules> getActiveModules() throws ConfigurationException, IOException {
		return moduleService.getActiveModules();
	}

	public List<ETMetaDataTable> getAllTables() throws ConfigurationException, IOException {
		return moduleService.getAllTables();
	}
	
	public List<ETMetaDataColumn> getColumnInformationByTableName(String tableName) throws ConfigurationException, IOException {
		return moduleService.getColumnInformationByTableName(tableName);
	}

	public List<ETFunctionalities> getFunctionalitiesByModuleId(Integer moduleId) throws ConfigurationException, IOException {
		return moduleService.getFunctionalitiesByModuleId(moduleId);
	}

	public Boolean saveConfiguration(ETRelationMetaData metadata) throws ConfigurationException, IOException {
		return moduleService.saveConfiguration(metadata);
	}

}
