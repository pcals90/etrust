package co.com.etrust.etapi.service.presale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etapi.dao.presale.IPresaleDAO;
import co.com.etrust.etapi.request.ETReviewDTO;
import co.com.etrust.etapi.request.ETReviewFiltersDTO;
import co.com.etrust.etapi.request.ETReviewRateDTO;
import co.com.etrust.etapi.response.dto.ETApiModuleDTO;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleadministration.service.IModuleService;

@Service("presaleService")
public class PresaleService implements IPresaleService {
	
	@Autowired
	private IModuleService moduleService;
	
	@Autowired
	private IPresaleDAO presaleDao;

	@Override
	public List<ETApiModuleDTO> getFunctionalities(String serviceName) throws ConfigurationException, IOException {
		return moduleService.getFunctionalities(serviceName);
	}

	@Override
	public Boolean addProductReview(ETReviewDTO review) throws ConfigurationException, IOException {
	
		Transaction tx = ETDBConnectionManager.initTransaction(moduleService.readExistingConfFromFile());
		try{
			Boolean ret =  presaleDao.addProductReview(review);
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return false;
	
	}

	@Override
	public List<ETReviewDTO> getProductReview(ETReviewFiltersDTO filters) throws ConfigurationException, IOException {
		Transaction tx = ETDBConnectionManager.initTransaction(moduleService.readExistingConfFromFile());
		try{
			List<ETReviewDTO> ret =  presaleDao.getProductReview(filters);
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return new ArrayList<ETReviewDTO>();
	}

	@Override
	public Boolean rateReview(ETReviewRateDTO rate) throws ConfigurationException, IOException {
		Transaction tx = ETDBConnectionManager.initTransaction(moduleService.readExistingConfFromFile());
		try{
			Boolean ret =  presaleDao.getProductReview(rate);
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return ret;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		return true;
	}
	
	
	

}
