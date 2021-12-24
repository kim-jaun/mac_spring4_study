package com.ch.jpa.configuration;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
	@Bean
	@ConfigurationProperties(prefix="spring.jpa")
	public Properties hibernateConfig(){
		return  new Properties();
	}
	@Bean 
	public EntityManagerFactory entityManagerFactory() { 
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); 
		vendorAdapter.setGenerateDdl(true); 
		LocalContainerEntityManagerFactoryBean factory = 
				new LocalContainerEntityManagerFactoryBean();
//	추가
		factory.setJpaDialect(new HibernateJpaDialect());
		factory.setDataSource(dataSource());
//	여기까지
		factory.setJpaVendorAdapter(vendorAdapter); 
		factory.setPackagesToScan("com.ch.jpa"); 
		factory.afterPropertiesSet();
		return factory.getObject(); 
	} 
	@Bean 
	public JpaTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) { 
		return new JpaTransactionManager(entityManagerFactory); 
	}
}