package com.project.site.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("me.samplespring.my_samples.domain")
@EnableJpaRepositories("me.samplespring.my_samples.repos")
@EnableTransactionManagement
public class DomainConfig {
}
