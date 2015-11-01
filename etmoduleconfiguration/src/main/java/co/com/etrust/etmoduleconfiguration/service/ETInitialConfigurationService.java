package co.com.etrust.etmoduleconfiguration.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Properties;

import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

@Service("initialConfService")
public class ETInitialConfigurationService {

	Properties prop = new Properties();
	String filePath = "";

	public boolean testConnection(String host, String port, String schema, String user, String password,
			String dbProvider) {

		return true;

	}

	public ETExistingInitialConfDTO getExistingConfiguration() throws IOException {

		return readExistingConfFromFile();
	}

	private ETExistingInitialConfDTO readExistingConfFromFile() throws IOException{
		ETExistingInitialConfDTO existing = new ETExistingInitialConfDTO();

		InputStream inStream = ETInitialConfigurationService.class.getResourceAsStream("etrust.conf");
		prop.load(inStream);
		existing.setHost(prop.getProperty("host"));
		existing.setPort(prop.getProperty("port"));
		existing.setDbName(prop.getProperty("dbname"));
		existing.setUser(prop.getProperty("user"));
		existing.setPassword(prop.getProperty("password"));
		existing.setDbProvider(prop.getProperty("dbprovider"));

		return existing;
	}

	public boolean saveNewInitialConfiguration(ETExistingInitialConfDTO conf) throws IOException{
		File file = new File("etrust.conf");
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
		
		FileOutputStream fos = new FileOutputStream(file);
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		bw.write("host = "+conf.getHost());
		bw.newLine();
		
		bw.write("port = "+conf.getHost());
		bw.newLine();
		
		bw.write("dbname = "+conf.getHost());
		bw.newLine();
		
		bw.write("user = "+conf.getHost());
		bw.newLine();
		
		bw.write("password = "+conf.getHost());
		bw.newLine();
		
		bw.write("dbprovider = "+conf.getHost());
		bw.newLine();
		
		bw.close();
		
		return true;
	}

}
