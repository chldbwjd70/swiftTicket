package com.example.infra.config;

import com.example.infra.Repositorys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableJpaAuditing(modifyOnCreate = false)
@Import({InfraRepositoryConfig.class, InfraPropertiesConfig.class})
@ComponentScan(basePackageClasses = {Repositorys.class})
public class InfraConfig {

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
