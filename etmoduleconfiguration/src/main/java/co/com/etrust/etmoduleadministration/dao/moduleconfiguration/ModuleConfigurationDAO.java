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

		Query query = sess
				.createSQLQuery(
						"SELECT TABLE_NAME as tableName FROM information_schema.tables where TABLE_SCHEMA = :dbname AND TABLE_TYPE = 'BASE TABLE' and TABLE_NAME not like 'et_%'")
				.setString("dbname", dbname).setResultTransformer(Transformers.aliasToBean(ETMetaDataTable.class));

		return query.list();
	}

	@Override
	public List<ETMetaDataColumn> getColumnInformationByTableName(String dbname, String tableName) {

		Session sess = ETDBConnectionManager.getCurrentSession();

		Query query = sess
				.createSQLQuery(
						"SELECT COLUMN_NAME as columnName,COLUMN_KEY as columnKey FROM information_schema.columns where TABLE_NAME=:tableName AND TABLE_SCHEMA = :dbname")
				.setString("tableName", tableName).setString("dbname", dbname).setString("dbname", dbname)
				.setResultTransformer(Transformers.aliasToBean(ETMetaDataColumn.class));

		return query.list();
	}

	@Override
	public List<ETMetaDataTable> getMetaDataTableByModuleId(Integer moudleId) {

		Session sess = ETDBConnectionManager.getCurrentSession();

		Query query = sess
				.createSQLQuery("Select table_id as tableId, table_name as tableName "
						+ " from et_meta_tables emt, et_modules em " + " where emt.module_id = em.module_id"
						+ " AND em.module_id = :moduleId")
				.setInteger("moduleId", moudleId).setResultTransformer(Transformers.aliasToBean(ETMetaDataTable.class));

		List<ETMetaDataTable> tables = query.list();

		for (ETMetaDataTable table : tables) {

			Query query2 = sess
					.createSQLQuery("Select column_name as columnName, column_type as columnKey"
							+ " FROM et_meta_columns emc, et_meta_tables emt " + " where emc.table_id = :tableId"
							+ " AND emc.table_id = emt.table_id")
					.setInteger("tableId", table.getTableId())
					.setResultTransformer(Transformers.aliasToBean(ETMetaDataColumn.class));

			List<ETMetaDataColumn> columns = query2.list();

			table.setColumns(columns);

		}

		return tables;

	}

}
