package learning.demo.mvc.application.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import learning.demo.repositories.UserRepository;

@Configuration
@EnableTransactionManagement
public class RepositoryConfig {
	
	@Value("${jdbc.dsn}")
	private String dsn;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String showSQL;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	
	@Bean(destroyMethod="")
	public DataSource getDataSource() {
		JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
		dsLookUp.setResourceRef(true);
		return dsLookUp.getDataSource(dsn);
	}
	

	@Bean
	@Autowired
	public Session getSession(SessionFactory sessionFactory) {
		return sessionFactory.openSession();
	}
	
	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSQL);
		properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan("learning.demo");
		return sessionFactory;
	}
	
	@Bean("transaction") 
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager();
	}
	

	//Repository configuration
	@Bean
	public UserRepository userRepository() {
		return new UserRepository();
	}
	
}
