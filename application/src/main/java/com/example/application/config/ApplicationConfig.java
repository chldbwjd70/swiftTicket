package com.example.application.config;

import com.example.application.ApplicationRoot;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ApplicationPropertiesConfig.class})
@ComponentScan(basePackageClasses = ApplicationRoot.class)
public class ApplicationConfig {
}
