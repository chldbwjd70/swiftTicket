package com.example.swiftTicket.config;

import com.example.application.config.ApplicationConfig;
import com.example.domain.config.DomainConfig;
import com.example.infra.config.JpaRepositoryConfig;
import com.example.swiftTicket.WebBeanRoot;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import({ DomainConfig.class, JpaRepositoryConfig.class, ApplicationConfig.class})
@ComponentScan(basePackageClasses = { WebBeanRoot.class })
public class WebAppConfig implements WebMvcConfigurer {
}
