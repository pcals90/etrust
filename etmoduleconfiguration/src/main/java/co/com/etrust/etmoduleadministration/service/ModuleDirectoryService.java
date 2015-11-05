package co.com.etrust.etmoduleadministration.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etapi.response.dto.ETApiModuleDTO;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleadministration.dao.directoryservice.IDirectoryServiceDAO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

@Service("moduleDirectoryService")
class ModuleDirectoryService {

	@Autowired
	private IDirectoryServiceDAO directoryDao;
	
	public List<ETApiModuleDTO> getFunctionalities(ETExistingInitialConfDTO etExistingInitialConfDTO, String serviceName) {

		Transaction tx = ETDBConnectionManager.initTransaction(etExistingInitialConfDTO);
		try{
			List<ETApiModuleDTO> ret =  directoryDao.getFunctionalities(serviceName);
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return new ArrayList<ETApiModuleDTO>();
	}
	
	

}
