package com.example.domain.config;

import com.example.domain.Domains;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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
import java.util.Properties;

@Configuration
@EnableMongoRepositories(basePackageClasses = { Domains.class })
@EnableJpaRepositories(basePackageClasses = { Domains.class })
@EntityScan(basePackageClasses = { Domains.class })
@ComponentScan(basePackageClasses = { DomainConfig.class })
public class DomainRepositoryConfig {


//    @Value("${portal.datasource.username:}")
    private String username;
//    @Value("${portal.datasource.password:}")
    private String password;
//    @Value("${portal.datasource.driverClassName}")
    private String driverClassName;
//    @Value("${portal.datasource.url}")
    private String url;


    @Bean
    @Qualifier("hikariDataSource")
    public DataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan("com.example.domain");
        factory.setDataSource(hikariDataSource());
        factory.setJpaProperties(jpaProperties());
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

    // TODO. 이 부분도 profile 별로 관리할 수 있도록 하면 좋을거 같음
    public Properties jpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MariaDBDialect");
        properties.setProperty("hibernate.show_sql","false");
        properties.setProperty("hibernate.format_sql","false");
        properties.setProperty("hibernate.physical_naming_strategy","org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        properties.setProperty("hibernate.implicit-strategy","org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
        return properties;
    }
}
