package name.tsymbaliuk.msite.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("name.tsymbaliuk.msite.app")
@EnableJpaRepositories("name.tsymbaliuk.msite.data")
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
public class RootConfig {

	@Value("name.tsymbaliuk.jpa.unit_name")
	String jpa_unit_name;
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		System.out.format("Unit: %s\n",jpa_unit_name);
		return Persistence.createEntityManagerFactory("persistenseUnit_Derby");
	}	

	@Bean
	public PlatformTransactionManager transactionManager() {
	
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	}	
}
