package co.com.etrust.etmoduleadministration.dao.moduleavailability;

import java.util.List;

import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;

public interface IModuleAvailabilityDAO {


	public List<ETCurrentModules> getCurrentModules();

	public boolean activateModule(Integer moduleId);

	public boolean deactivateModule(Integer moduleId);

	public List<ETCurrentModules> getActiveModules();
}
