package co.com.etrust.etmoduleadministration.dao.directoryservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import co.com.etrust.etapi.response.dto.ETApiFunctionalityDTO;
import co.com.etrust.etapi.response.dto.ETApiModuleDTO;
import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;

@Repository("directoryServiceDAO")
public class DirectoryServiceDAO implements IDirectoryServiceDAO {

	@Override
	public List<ETApiModuleDTO> getFunctionalities(String serviceName) {
		Session sess = ETDBConnectionManager.getCurrentSession();
		sess.getTransaction();

		List<ETApiModuleDTO> results = new ArrayList<ETApiModuleDTO>();
		Query query = sess
				.createSQLQuery(
						"SELECT em.module_Name as moduleName, em.module_Description as moduleDescription,"
						+ " ef.name as name, ef.html_Element as htmlElement "
						+ " FROM et_service_directory sd, et_modules em, et_functionalities ef, et_module_service ms"
						+ " Where sd.service_name = :serviceName"
						+ " AND ms.service_id = sd.id_service"
						+ "	AND ms.module_id = em.module_id"
						+ "	AND em.module_id = ef.module_id"
						+ "	AND em.module_status = 'active'"
						+ " AND ef.status = 'active'").setString("serviceName", serviceName);

		Iterator i = query.list().iterator();
		
		while (i.hasNext()) {
			Object [] tuple = (Object [])i.next();
			
			
			boolean found = false;
			for (ETApiModuleDTO mod : results) {
				
				if(mod.getModuleName().equals((String)tuple[0])){
					mod.setModuleName((String)tuple[0]);
					mod.setModuleDescription((String)tuple[1]);
					
					ETApiFunctionalityDTO func = new ETApiFunctionalityDTO();
					func.setName((String)tuple[2]);
					func.setHtmlElement((String)tuple[3]);
					
					mod.getFunctionalities().add(func);
					
					found = true;
				}
				
			}
			
			if(!found){

				ETApiModuleDTO module = new ETApiModuleDTO();
				module.setModuleName((String)tuple[0]);
				module.setModuleDescription((String)tuple[1]);
				module.setFunctionalities(new ArrayList<ETApiFunctionalityDTO>());
				ETApiFunctionalityDTO func = new ETApiFunctionalityDTO();
				func.setName((String)tuple[2]);
				func.setHtmlElement((String)tuple[3]);
				
				module.getFunctionalities().add(func);
				results.add(module);
					
			}
						
		}
		return results;
	}

	

}
