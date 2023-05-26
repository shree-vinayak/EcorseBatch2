package com.sv.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages={"com.sv.repository"},
entityManagerFactoryRef="vibEntityManager",
transactionManagerRef="vibTransactionManager"
		)
public class DatabaseConfiguration {

	@Autowired Environment env;
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean vibEntityManager()
	{
		LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(vibDataSource());
        em.setPackagesToScan(new String[]{"com.sv.entity"});
        em.setPersistenceUnitName("vibEntityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect",
                env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show-sql",
                env.getProperty("spring.jpa.show-sql"));
        properties.put("hibernate.format_sql",
                env.getProperty("spring.jpa.properties.hibernate.format_sql"));
//        properties.put("hibernate.hbm2ddl.auto",
//                "update");
        em.setJpaPropertyMap(properties);
		return em;
	}

    @Primary
    @Bean
	public DataSource vibDataSource()
	{
		DriverManagerDataSource dc1=new DriverManagerDataSource();
		
		 dc1.setDriverClassName(
	                env.getProperty("spring.datasource.driver-class-name"));
	        dc1.setUrl(env.getProperty("spring.datasource.url"));
	        dc1.setUsername(env.getProperty("spring.datasource.username"));
	        dc1.setPassword(env.getProperty("spring.datasource.password"));
		
		return dc1;
	}
	
  	    @Primary
	    @Bean
	    public PlatformTransactionManager vibTransactionManager() {

	        JpaTransactionManager transactionManager
	                = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(
	                vibEntityManager().getObject());
	        return transactionManager;
	    }
}
