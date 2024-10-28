package com.example.domain.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Slf4j
public class DomainPropertiesConfig {


    @Profile("develop")
    @PropertySource({"classpath:domain.properties"})
    public static class DomainDevelopProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer DomainPropertyConfig() {
            log.info("Current profile : develop");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("production")
    @PropertySource({"classpath:domain.properties"})
    public static class DomainProductionProperties   {
        @Bean
        public static PropertySourcesPlaceholderConfigurer DomainPropertyConfig() {
            log.info("Current profile : production");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("local")
    @PropertySource({"classpath:domain.properties"})
    public static class DomainLocalProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer DomainPropertyConfig() {
            log.info("Current profile : local");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
    @Profile("test")
    @PropertySource({"classpath:domain.properties"})
    public static class DomainTestProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer DomainPropertyConfig() {
            log.info("Current profile : test");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
}

