package com.tf.usermanagement;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.spaneos.dtssp.PaginatedDataFetcherService;
import com.spaneos.dtssp.PaginatedDataFetcherServiceImpl;

@Configuration
@PropertySources({ @PropertySource("classpath:db.properties"), @PropertySource("classpath:hibernate.properties") })
public class ThoughtFocusAdminModuleConfig {

	// DB properties
	@Value("${db.driver}")
	private String DATABASE_DRIVER;
	@Value("${db.password}")
	private String DATABASE_PASSWORD;
	@Value("${db.url}")
	private String DATABASE_URL;
	@Value("${db.username}")
	private String DATABASE_USERNAME;
	@Value("${db.maxactive}")
	private int MAXACTIVE;

	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	@Value("${hibernate.hbm2ddl.auto}")

	private String HIBERNATE_HBM2DDL_AUTO;
 	
 	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(DATABASE_DRIVER);
		basicDataSource.setUrl(DATABASE_URL);
		basicDataSource.setUsername(DATABASE_USERNAME);
		basicDataSource.setPassword(DATABASE_PASSWORD);
		basicDataSource.setMaxActive(MAXACTIVE);
		basicDataSource.setMaxActive(-1);
		
		return basicDataSource;
	}

	@Bean(name = "paginatedDataFetcherService")
	public PaginatedDataFetcherService dataFetcherService() {
		PaginatedDataFetcherService obj = new PaginatedDataFetcherServiceImpl();
		return obj;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		sessionFactory.setHibernateProperties(hibernateProperties);
		System.out.println(
				"THE values are" + HIBERNATE_DIALECT + " " + HIBERNATE_SHOW_SQL + " " + HIBERNATE_HBM2DDL_AUTO);
		//sessionFactory.setPa("com.mmdworks.hsdemo.pojo");
		sessionFactory.setPackagesToScan("com.tf.usermanagement");
		return sessionFactory;
	}
	
	 @Bean
	    public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }

}
