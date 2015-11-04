package co.com.etrust.etmoduleadministration.dao.moduleconfiguration;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import co.com.etrust.etmoduleadministration.dao.connection.ETDBConnectionManager;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataColumn;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataTable;

@Repository("moduleConfigurationDAO")
public class ModuleConfigurationDAO implements IModuleConfigurationDAO {

	@Override
	public List<ETMetaDataTable> getAllTables(String dbname) {

		Session sess = ETDBConnectionManager.getCurrentSession();
		sess.getTransaction();

		Query query = sess
				.createSQLQuery(
						"SELECT TABLE_NAME as tableName FROM information_schema.tables where TABLE_SCHEMA = :dbname AND TABLE_TYPE = 'BASE TABLE' and TABLE_NAME not like 'et_%'")
				.setString("dbname", dbname).setResultTransformer(Transformers.aliasToBean(ETMetaDataTable.class));

		return query.list();
	}

	@Override
	public List<ETMetaDataColumn> getColumnInformationByTableName(String dbname, String tableName) {

		Session sess = ETDBConnectionManager.getCurrentSession();
		sess.getTransaction();

		Query query = sess
				.createSQLQuery(
						"SELECT COLUMN_NAME as columnName,COLUMN_KEY as columnKey FROM information_schema.columns where TABLE_NAME=:tableName AND TABLE_SCHEMA = :dbname")
				.setString("tableName", tableName).setString("dbname", dbname)
				.setString("dbname", dbname).setResultTransformer(Transformers.aliasToBean(ETMetaDataColumn.class));

		return query.list();
	}

}
