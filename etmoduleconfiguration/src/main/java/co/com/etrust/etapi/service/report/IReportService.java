package co.com.etrust.etapi.service.report;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;

public interface IReportService {
	
	public List<Object> getReportByModuleId(Integer moduleId)throws ConfigurationException, IOException;

}
