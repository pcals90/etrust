package co.com.etrust.etmoduleadministration.dao.connection;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import co.com.etrust.etmoduleconfiguration.response.dto.ETExistingInitialConfDTO;

public class ETDBConnectionManager {

	private static ETDBConnectionManager instance = null;

	private SessionFactory sessionFactory;

	private ETDBConnectionManager() {
	}

	public static ETDBConnectionManager getInstance() {
		if (instance == null) {
			instance = new ETDBConnectionManager();
			return instance;
		}

		return instance;

	}

	public static boolean initSessionFactroy(String host, String dbName, String port, String user, String password,
			String dbProvider) {

		if (getInstance().sessionFactory != null)
			return true;

		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.current_session_context_class", "thread");
		// driver settings
		switch (dbProvider) {
		case "mysql":
			properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			break;
		}
		properties.put("hibernate.connection.url", "jdbc:mysql://" + host + ":" + port + "/" + dbName);
		properties.put("hibernate.connection.username", user);
		properties.put("hibernate.connection.password", password);

		getInstance().sessionFactory = new Configuration().addProperties(properties)
				.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(properties).build());

		if (getInstance().sessionFactory == null)
			return false;
		else
			return true;

	}

	public static boolean initSessionFactroy(ETExistingInitialConfDTO dto) {
		return initSessionFactroy(dto.getHost(), dto.getDbName(), dto.getPort(), dto.getUser(), dto.getPassword(),
				dto.getDbProvider());
	}

	public static Session getCurrentSession() {
		return getInstance().sessionFactory.getCurrentSession();
	}

	public static boolean closeAndCommitTransaction(Transaction tx) {
		tx.commit();
		getCurrentSession().close();
		return true;
	}

	public static void manageTransactionException(RuntimeException e, Transaction tx) {
		try {
			tx.rollback();
		} catch (RuntimeException rbe) {
			rbe.printStackTrace();
		}
		throw e;
	}

	public static Transaction initTransaction(ETExistingInitialConfDTO dto) {
		initSessionFactroy(dto);
		getCurrentSession().beginTransaction();
		return getCurrentSession().getTransaction();
	}

}
