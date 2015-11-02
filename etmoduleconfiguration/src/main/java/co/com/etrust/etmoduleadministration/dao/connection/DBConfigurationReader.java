package co.com.etrust.etmoduleadministration.dao.connection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

public class DBConfigurationReader {
	
	
	private static PropertiesConfiguration prop = new PropertiesConfiguration();
	private static final String CONF_FILE_PRATH = "/home/pcals90/desarrollo/tg/props/etrust.conf";
	private static final String CONF_FILE_NAME = "etrust.conf";

	public static ETExistingInitialConfDTO readExistingConfFromFile() throws ConfigurationException {
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
	
	public static boolean saveNewInitialConfiguration(ETExistingInitialConfDTO conf) throws IOException, ConfigurationException{

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
	

	
	
}
