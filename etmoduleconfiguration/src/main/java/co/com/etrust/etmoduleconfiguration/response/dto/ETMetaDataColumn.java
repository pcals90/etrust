package co.com.etrust.etmoduleconfiguration.response.dto;

public class ETMetaDataColumn {

	private String columnName;
	private String columnKey;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	@Override
	public String toString() {
		return "ETMetaDataColumn [columnName=" + columnName + ", columnKey=" + columnKey + "]";
	}
	
	
	
	
}
