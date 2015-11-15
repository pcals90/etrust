package co.com.etrust.etapi.service.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etapi.dao.report.IReportDAO;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleadministration.service.IModuleService;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataTable;

@Service("reportService")
public class ReportService implements IReportService {
	
	@Autowired
	private IModuleService moduleService;
	
	@Autowired
	private IReportDAO reportDao;

	@Override
	public List<Object> getReportByModuleId(Integer moduleId) throws ConfigurationException, IOException {
		
		List<ETMetaDataTable> tables = moduleService.getMetaDataTableByModuleId(moduleId);
		
		Transaction tx = ETDBConnectionManager.initTransaction(moduleService.readExistingConfFromFile());
		List<Object> report = new ArrayList<>();
		try{
			switch (moduleId){
			case 1:
				report = reportDao.getReviewReport(tables);
				break;
			}
			
			ETDBConnectionManager.closeAndCommitTransaction(tx);
			return report;
		}catch(RuntimeException re){
			ETDBConnectionManager.manageTransactionException(re, tx);
		}
		
		return new ArrayList<Object> ();
	}

	

//	@Override
//	public Boolean rateReview(ETReviewRateDTO rate) throws ConfigurationException, IOException {
//		Transaction tx = ETDBConnectionManager.initTransaction(moduleService.readExistingConfFromFile());
//		try{
//			Boolean ret =  presaleDao.getProductReview(rate);
//			ETDBConnectionManager.closeAndCommitTransaction(tx);
//			return ret;
//		}catch(RuntimeException re){
//			ETDBConnectionManager.manageTransactionException(re, tx);
//		}
//		return true;
//	}
	
	
	

}
