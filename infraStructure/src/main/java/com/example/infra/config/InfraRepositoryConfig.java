package com.example.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JpaRepositoryConfig.class, MongoRepositoryConfig.class})
public class InfraRepositoryConfig {
}
