package io.mauth.fakefood.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
@EnableJpaRepositories(
        basePackages = "io.mauth.fakefood",
        entityManagerFactoryRef = "fakeFoodEntityManager",
        transactionManagerRef = "fakeFoodTransactionManager"
)
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean(name = "fakeFoodEntityManager")
    public LocalContainerEntityManagerFactoryBean calicoSiteEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("fakeFoodDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("io.mauth.fakefood.model")
                .build();
    }

    @Bean(name = "fakeFoodDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource fakeFoodDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "fakeFoodTransactionManager")
    @Primary
    public JpaTransactionManager fakeFoodTransactionManager(
            @Qualifier("fakeFoodEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
