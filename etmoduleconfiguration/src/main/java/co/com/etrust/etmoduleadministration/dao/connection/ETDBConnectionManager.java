package co.com.etrust.etmoduleadministration.dao.connection;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ETDBConnectionManager {

	private static ETDBConnectionManager instance = null;
	
	private SessionFactory sessionFactory;
	
	private ETDBConnectionManager(){}
	
	public static ETDBConnectionManager getInstance(){
		if (instance == null){
			instance = new ETDBConnectionManager();
			return instance;
		}
		
		return instance;
			
	}
	
	public static boolean initSessionFactroy(String host, String dbName, String port, String user, String password,
			String dbProvider){
		
		Properties properties = new Properties();
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    //driver settings
		switch (dbProvider) {
			case "mysql":
				properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			break;
		}
	    properties.put("hibernate.connection.url", "jdbc:mysql://"+host+":"+port+"/"+dbName);
	    properties.put("hibernate.connection.username", user);
	    properties.put("hibernate.connection.password", password);
	 
	    getInstance().sessionFactory = new Configuration()
	            .addProperties(properties)
	            .buildSessionFactory(
	                    new StandardServiceRegistryBuilder()
	                            .applySettings(properties)
	                            .build()
	    );
	    
	    if (getInstance().sessionFactory == null)
	    	return false;
	    else 
	    	return true;
	    
	}
	
}
