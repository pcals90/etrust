package co.com.etrust.etmoduleadministration.dao.moduleavailability;

import java.util.List;

import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;
import co.com.etrust.etmoduleconfiguration.response.dto.ETFunctionalities;
import co.com.etrust.etmoduleconfiguration.response.dto.ETRelationMetaData;

public interface IModuleAvailabilityDAO {


	public List<ETCurrentModules> getCurrentModules();

	public boolean activateModule(Integer moduleId);

	public boolean deactivateModule(Integer moduleId);

	public List<ETCurrentModules> getActiveModules();

	public List<ETFunctionalities> getFunctionalitiesByModuleId(Integer moduleId);

	public boolean saveConfiguration(ETRelationMetaData metadata);
}
