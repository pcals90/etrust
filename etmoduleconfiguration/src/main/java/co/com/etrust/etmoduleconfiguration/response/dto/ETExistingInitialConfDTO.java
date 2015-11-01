package co.com.etrust.etmoduleconfiguration.response.dto;


public class ETExistingInitialConfDTO {

	private String host;
	
	private String dbName;
	
	private String port;
	
	private String user;
	
	private String password;
	
	private String dbProvider;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbProvider() {
		return dbProvider;
	}

	public void setDbProvider(String dbProvider) {
		this.dbProvider = dbProvider;
	}
	
	
	
}
