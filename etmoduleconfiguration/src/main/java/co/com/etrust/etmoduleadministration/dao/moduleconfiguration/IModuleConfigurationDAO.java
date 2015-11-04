package co.com.etrust.etmoduleadministration.dao.moduleconfiguration;

import java.util.List;

import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataColumn;
import co.com.etrust.etmoduleconfiguration.response.dto.ETMetaDataTable;

public interface IModuleConfigurationDAO {

	List<ETMetaDataTable> getAllTables(String string);

	List<ETMetaDataColumn> getColumnInformationByTableName(String dbName, String tableName);



}
