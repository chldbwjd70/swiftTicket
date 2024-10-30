package com.example.domain.config;


import com.example.domain.Domains;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({DomainPropertiesConfig.class})
@ComponentScan(basePackageClasses = {Domains.class})
@EntityScan(basePackageClasses = { Domains.class })
public class DomainConfig {


}
