package com.example.infra.config;

import com.example.domain.Domains;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableMongoRepositories(basePackageClasses = { Domains.class })
@EnableJpaRepositories(basePackageClasses = { Domains.class })
@ComponentScan(basePackageClasses = { InfraConfig.class })
public class JpaRepositoryConfig {


    @Value("${infra.datasource.username}")
    private String username;
    @Value("${infra.datasource.password}")
    private String password;
    @Value("${infra.datasource.driverClassName}")
    private String driverClassName;
    @Value("${infra.datasource.url}")
    private String url;

    private JpaProperties jpaProperties;

    public JpaRepositoryConfig(JpaProperties jpaProperties) {
        this.jpaProperties = jpaProperties;
    }

    @Bean
    @Qualifier("hikariDataSource")
    public DataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan("com.example.domain");
        factory.setDataSource(hikariDataSource());
        factory.setJpaProperties(jpaProperties.jpaProperties());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("hikariDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
