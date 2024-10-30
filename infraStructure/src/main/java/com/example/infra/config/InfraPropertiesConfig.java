package com.example.infra.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Slf4j
public class InfraPropertiesConfig {

    @Profile("develop")
    @PropertySource({"classpath:infraStructure.properties"})
    public static class InfraStructureDevelopProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer InfraStructurePropertyConfig() {
            log.info("Current profile : develop");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("production")
    @PropertySource({"classpath:infraStructure.properties"})
    public static class InfraStructureProductionProperties   {
        @Bean
        public static PropertySourcesPlaceholderConfigurer InfraStructurePropertyConfig() {
            log.info("Current profile : production");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("local")
    @PropertySource({"classpath:infraStructure.properties"})
    public static class InfraStructureLocalProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer InfraStructurePropertyConfig() {
            log.info("Current profile : local");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Profile("test")
    @PropertySource({"classpath:infraStructure.properties"})
    public static class InfraStructureTestProperties  {
        @Bean
        public static PropertySourcesPlaceholderConfigurer InfraStructurePropertyConfig() {
            log.info("Current profile : test");
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
}
