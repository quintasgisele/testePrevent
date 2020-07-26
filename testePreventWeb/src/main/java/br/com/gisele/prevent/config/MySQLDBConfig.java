package br.com.gisele.prevent.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory", transactionManagerRef = "mysqlTransactionManager", basePackages = {
		"br.com.gisele.prevent.repository" })
public class MySQLDBConfig {
	@Bean(name = "mysqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mysqlDataSource") DataSource dataSource) {

		Map<String, String> jpaProperties = new HashMap<>();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return builder.dataSource(dataSource).properties(jpaProperties)
				.packages("br.com.gisele.prevent.domain").persistenceUnit("mysql").build();
	}

	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager barTransactionManager(
			@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(barEntityManagerFactory);

		return txManager;
	}

}
