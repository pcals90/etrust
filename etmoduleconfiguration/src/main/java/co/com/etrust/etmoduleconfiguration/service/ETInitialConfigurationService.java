package co.com.etrust.etmoduleconfiguration.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleadministration.service.IModuleService;
import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

@Service("initialConfService")
public class ETInitialConfigurationService {

	PropertiesConfiguration prop = new PropertiesConfiguration();
	private static final String CONF_FILE_PRATH = "/home/pcals90/desarrollo/tg/props/etrust.conf";
	private static final String CONF_FILE_NAME = "etrust.conf";
	
	@Autowired
	private IModuleService moduleService;
	
	public boolean testConnection(String host, String port, String schema, String user, String password,
			String dbProvider) {

		
		return moduleService.testConnection(host, schema, port, user, password, dbProvider);

	}

	public ETExistingInitialConfDTO getExistingConfiguration() throws IOException, ConfigurationException {

		return readExistingConfFromFile();
	}

	private ETExistingInitialConfDTO readExistingConfFromFile() throws IOException, ConfigurationException{
		ETExistingInitialConfDTO existing = new ETExistingInitialConfDTO();

		File appEnvPropOverrideFile=new File(CONF_FILE_PRATH);
		prop.load(appEnvPropOverrideFile);
		existing.setHost( prop.getString("host"));
		existing.setPort(prop.getString("port"));
		existing.setDbName(prop.getString("dbname"));
		existing.setUser(prop.getString("user"));
		existing.setPassword(prop.getString("password"));
		existing.setDbProvider(prop.getString("dbprovider"));

		return existing;
	}

	public boolean saveNewInitialConfiguration(ETExistingInitialConfDTO conf) throws IOException, ConfigurationException{

		File appEnvPropOverrideFile=new File(CONF_FILE_PRATH);
		prop.load(appEnvPropOverrideFile);
		prop.setFileName("etrust.conf");
		FileOutputStream out = new FileOutputStream(CONF_FILE_NAME);
		prop.setProperty("host", conf.getHost());
		prop.setProperty("port", conf.getPort());
		prop.setProperty("dbname", conf.getDbName());
		prop.setProperty("user", conf.getUser());
		prop.setProperty("password", conf.getPassword());
		prop.setProperty("dbprovider", conf.getDbProvider());
		prop.save();
		out.close();
		
		return true;
	}

	public List<ETCurrentModules> getCurrentModules() {
		
		
		
		return null;
	}

}
