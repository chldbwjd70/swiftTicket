package com.example.application.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Slf4j
public class ApplicationPropertiesConfig {

    @Profile("develop")
    @PropertySource({"classpath:application.properties"})
    public static class ApplicationDevelopProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer ApplicationPropertyConfig() {
            log.info("Current profile : develop");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("production")
    @PropertySource({"classpath:application.properties"})
    public static class ApplicationProductionProperties   {
        @Bean
        public static PropertySourcesPlaceholderConfigurer ApplicationPropertyConfig() {
            log.info("Current profile : production");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("local")
    @PropertySource({"classpath:application.properties"})
    public static class ApplicationLocalProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer ApplicationPropertyConfig() {
            log.info("Current profile : local");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("test")
    @PropertySource({"classpath:application.properties"})
    public static class ApplicationTestProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer ApplicationPropertyConfig() {
            log.info("Current profile : test");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
}
