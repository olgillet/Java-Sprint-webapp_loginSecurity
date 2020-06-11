package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.app.repository")
@ComponentScan(basePackages = "com.app")
@Import({ WebConfig.class, JPAConfig.class, SecurityConfig.class })
public class AppConfig {

}
