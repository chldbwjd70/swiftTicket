package com.example.domain.config;

import com.example.domain.Domains;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaAuditing(modifyOnCreate = false)
@Import({DomainPropertiesConfig.class, DomainRepositoryConfig.class})
@ComponentScan(basePackageClasses = {Domains.class})
@EntityScan(basePackageClasses = { Domains.class })
public class DomainConfig {

//    @Value("${threadpool.core}")
    private int threadPoolCore = 15;
//    @Value("${threadpool.max}")
    private int threadPoolMax = 30;
//    @Value("${threadpool.queue}")
    private int threadPoolQueue = 10;

    @Bean(name = "objectMapper")
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Bean
    public ThreadPoolTaskExecutor eventTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("app-share-pool");
        executor.setCorePoolSize(threadPoolCore);
        executor.setMaxPoolSize(threadPoolMax);
        executor.setQueueCapacity(threadPoolQueue);
        executor.afterPropertiesSet();
        return executor;
    }


}
