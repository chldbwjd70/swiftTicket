package com.example.application.config;

import com.example.application.WebBeanRoot;
import com.example.domain.config.DomainConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@Import({ DomainConfig.class, ApplicationConfig.class, WebAppPropertiesConfig.class, ClusterConfig.class, ResourceSyncConfig.class,})
@Import({ DomainConfig.class, ApplicationPropertiesConfig.class})
@ComponentScan(basePackageClasses = { WebBeanRoot.class })
public class WebAppConfig implements WebMvcConfigurer {


}
