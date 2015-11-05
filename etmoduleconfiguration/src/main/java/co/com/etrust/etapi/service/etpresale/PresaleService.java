package co.com.etrust.etapi.service.etpresale;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.etrust.etapi.response.dto.ETApiModuleDTO;
import co.com.etrust.etmoduleadministration.service.IModuleService;

@Service("presaleService")
public class PresaleService implements IPresaleService {
	
	@Autowired
	private IModuleService moduleService;

	@Override
	public List<ETApiModuleDTO> getFunctionalities(String serviceName) throws ConfigurationException, IOException {
		return moduleService.getFunctionalities(serviceName);
	}
	

}
