package co.com.etrust.etmoduleadministration.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleadministration.dao.moduleavailability.IModuleAvailabilityDAO;
import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;
import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

@Service("moduleAvailabilityService")
class ModuleAvailabilityService {

	@Autowired
	private IModuleAvailabilityDAO availabilityDao;
	
	public List<ETCurrentModules> getCurrentModules(ETExistingInitialConfDTO etExistingInitialConfDTO) {
		
		Transaction tx = ETDBConnectionManager.initTransaction(etExistingInitialConfDTO);
		try{
			List<ETCurrentModules> ret =  availabilityDao.getCurrentModules();
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return new ArrayList<ETCurrentModules>();
	}

	public boolean activateModule(Integer moduleId,ETExistingInitialConfDTO etExistingInitialConfDTO) {
		Transaction tx = ETDBConnectionManager.initTransaction(etExistingInitialConfDTO);
		try{
			boolean ret =  availabilityDao.activateModule(moduleId);
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return false;
	}

	public boolean deactivateModule(Integer moduleId,ETExistingInitialConfDTO etExistingInitialConfDTO) {
		
		Transaction tx = ETDBConnectionManager.initTransaction(etExistingInitialConfDTO);
		try{
			boolean ret =  availabilityDao.deactivateModule(moduleId);
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return false;
	}

	public List<ETCurrentModules> getActiveModules(ETExistingInitialConfDTO etExistingInitialConfDTO) {
		Transaction tx = ETDBConnectionManager.initTransaction(etExistingInitialConfDTO);
		try{
			List<ETCurrentModules> ret =  availabilityDao.getActiveModules();
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return new ArrayList<ETCurrentModules>();
	}
	

}
