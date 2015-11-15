package co.com.etrust.etapi.dao.report;

import java.util.List;

import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataTable;

public interface IReportDAO {
	
	public List<Object> getReviewReport(List<ETMetaDataTable> tables);
	
}
