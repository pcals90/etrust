package co.com.etrust.etmoduleadministration.dao.directoryservice;

import java.util.List;

import co.com.etrust.etapi.response.dto.ETApiModuleDTO;

public interface IDirectoryServiceDAO {

	public List<ETApiModuleDTO> getFunctionalities(String serviceName);

}
