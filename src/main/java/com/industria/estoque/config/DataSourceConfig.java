package com.industria.estoque.config;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

//    private final SecretConfig secretConfig;

    @Bean
    public DataSource dataSource() {
        System.out.println(System.getenv("POSTGRES_USER"));
        System.out.println(System.getenv("POSTGRES_PASSWORD"));
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://172.22.146.136:5432/postgres") // mantive assim para testar localmente com variaveis locais
                .username(System.getenv("POSTGRES_USER"))
                .password(System.getenv("POSTGRES_PASSWORD"))
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .baselineOnMigrate(true)
                .load();
    }

}
