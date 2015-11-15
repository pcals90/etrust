package co.com.etrust.etmoduleconfiguration.response.dto;

import java.util.List;

public class ETMetaDataTable {
	
	private int tableId;
	private String tableName;
	
	private List<ETMetaDataColumn> columns;

	public List<ETMetaDataColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<ETMetaDataColumn> columns) {
		this.columns = columns;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@Override
	public String toString() {
		return "ETMetaDataTable [tableId=" + tableId + ", tableName=" + tableName + ", columns=" + columns + "]";
	}

	
	
	

}
