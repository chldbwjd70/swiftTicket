package com.example.infra.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Profile({ "production" })
@Component
public class JpaPropertiesForProduction implements JpaProperties {
    public Properties jpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MariaDBDialect");
        properties.setProperty("hibernate.show_sql","false");
        properties.setProperty("hibernate.format_sql","false");
        properties.setProperty("hibernate.physical_naming_strategy","org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        properties.setProperty("hibernate.implicit-strategy","org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
        return properties;
    }
}
