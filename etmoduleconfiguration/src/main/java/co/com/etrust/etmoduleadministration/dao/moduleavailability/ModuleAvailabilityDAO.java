package co.com.etrust.etmoduleadministration.dao.moduleavailability;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleconfiguration.response.dto.ETCurrentModules;
import co.com.etrust.etmoduleconfiguration.response.dto.ETFunctionalities;

@Repository("moduleAvailabilityDAO")
public class ModuleAvailabilityDAO implements IModuleAvailabilityDAO {

	@Override
	public List<ETCurrentModules> getCurrentModules() {

		Session sess = ETDBConnectionManager.getCurrentSession();

		Query query = sess
				.createSQLQuery(
						"SELECT module_id as moduleId, module_Name as moduleName, module_status as moduleStatus, "
								+ " module_description as moduleDescription " + " FROM et_modules"
								+ " WHERE module_id = 1")
				.setResultTransformer(Transformers.aliasToBean(ETCurrentModules.class));

		return query.list();
	}

	@Override
	public boolean activateModule(Integer moduleId) {

		Session sess = ETDBConnectionManager.getCurrentSession();

		Query query = sess.createSQLQuery("UPDATE et_modules set module_status = 'active' WHERE module_id = :moduleId")
				.setParameter("moduleId", moduleId)
				.setResultTransformer(Transformers.aliasToBean(ETCurrentModules.class));

		return query.executeUpdate() > 0;

	}

	@Override
	public boolean deactivateModule(Integer moduleId) {

		Session sess = ETDBConnectionManager.getCurrentSession();

		Query query = sess.createSQLQuery("UPDATE et_modules set module_status = 'off' WHERE module_id = :moduleId")
				.setParameter("moduleId", moduleId)
				.setResultTransformer(Transformers.aliasToBean(ETCurrentModules.class));

		return query.executeUpdate() > 0;
	}

	@Override
	public List<ETCurrentModules> getActiveModules() {
		Session sess = ETDBConnectionManager.getCurrentSession();

		Query query = sess
				.createSQLQuery(
						"SELECT module_id as moduleId, module_Name as moduleName, module_status as moduleStatus, "
								+ " module_description as moduleDescription " + " FROM et_modules"
								+ " WHERE module_status = 'active'")
				.setResultTransformer(Transformers.aliasToBean(ETCurrentModules.class));

		return query.list();
	}

	@Override
	public List<ETFunctionalities> getFunctionalitiesByModuleId(Integer moduleId) {
		Session sess = ETDBConnectionManager.getCurrentSession();

		Query query = sess
				.createSQLQuery("SELECT functionality_id as id, name as name, module_id as moduleId, status as status  "
						+ " FROM et_functionalities " + " WHERE module_id = :moduleId")
				.setInteger("moduleId", moduleId)
				.setResultTransformer(Transformers.aliasToBean(ETFunctionalities.class));

		return query.list();
	}

	@Override
	public boolean saveConfiguration(List<ETFunctionalities> functionalities) {
		Session sess = ETDBConnectionManager.getCurrentSession();
		
		for (ETFunctionalities func : functionalities) {
			Query query = sess
					.createSQLQuery(
							"UPDATE et_functionalities set status = :status WHERE functionality_id=:id and module_id = :moduleId");
			query.setString("status", func.getStatus());
			query.setInteger("id", func.getId());
			query.setInteger("moduleId", func.getModuleId());
			query.executeUpdate();
		}
		
		return true;
	}

}
