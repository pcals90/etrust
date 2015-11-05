package co.com.etrust.etapi.service.etpresale;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;

import co.com.etrust.etapi.response.dto.ETApiModuleDTO;

public interface IPresaleService {
	
	public List<ETApiModuleDTO> getFunctionalities(String serviceName)throws ConfigurationException, IOException;

}
