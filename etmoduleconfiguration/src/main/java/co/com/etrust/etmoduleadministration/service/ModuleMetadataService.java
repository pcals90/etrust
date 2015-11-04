package co.com.etrust.etmoduleadministration.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleadministration.dao.connection.DBConfigurationReader;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleadministration.dao.moduleconfiguration.IModuleConfigurationDAO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataColumn;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataTable;

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

	public List<ETMetaDataTable> getAllTables(ETExistingInitialConfDTO etExistingInitialConfDTO) {

		Transaction tx = ETDBConnectionManager.initTransaction(etExistingInitialConfDTO);
		try{
			List<ETMetaDataTable> ret =  configurationDAO.getAllTables(etExistingInitialConfDTO.getDbName());
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return new ArrayList<ETMetaDataTable>();
	
		
	}
	
	public List<ETMetaDataColumn> getColumnInformationByTableName(ETExistingInitialConfDTO etExistingInitialConfDTO, String tableName) {

		Transaction tx = ETDBConnectionManager.initTransaction(etExistingInitialConfDTO);
		try{
			List<ETMetaDataColumn> ret =  configurationDAO.getColumnInformationByTableName(etExistingInitialConfDTO.getDbName(),tableName);
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return new ArrayList<ETMetaDataColumn>();
	
		
	}
	
	
}
