package name.tsymbaliuk.msite.app;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import java.util.Properties;

//import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("database.properties")
@ComponentScan("name.tsymbaliuk.msite.app")
@EnableJpaRepositories("name.tsymbaliuk.msite.app.data")
@EnableTransactionManagement
public class RootConfig {
	static String jpa_unit_name="msite_unit";

	@Inject
	Environment env;

	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

//		dataSource.setDriverClassName("${jdbc.driver}");
//		dataSource.setUrl("${jdbc.url}");
//		dataSource.setUsername("${jdbc.username}");
//		dataSource.setPassword("${jdbc.password}");

		dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactory.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
        entityManagerFactory.setPackagesToScan("name.tsymbaliuk.msite.app");

        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		properties.put("hibernate.connection.charSet", "UTF-8");
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.flushMode", env.getProperty("hibernate.flushMode"));

        properties.list( System.out );
        entityManagerFactory.setJpaProperties(properties);
		return entityManagerFactory;
	}	

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	    return transactionManager;
	}
//    @Bean
//    public HibernateExceptionTranslator hibernateExceptionTranslator(){
//      return new HibernateExceptionTranslator();
//    }
}
