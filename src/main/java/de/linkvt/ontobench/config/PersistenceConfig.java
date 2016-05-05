package de.linkvt.ontobench.config;

import com.zaxxer.hikari.HikariDataSource;

import de.linkvt.ontobench.config.conditions.PostgreSqlUrlCondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

/**
 * Configuration for the database.
 */
@Configuration
public class PersistenceConfig {

  @Bean
  @Conditional(PostgreSqlUrlCondition.class)
  public DataSource dataSource(Environment env) throws URISyntaxException {
    final String DATABASE_URL = env.getProperty("DATABASE_URL");

    return createHerokuDataSource(DATABASE_URL);
  }

  private DataSource createHerokuDataSource(final String databaseUrl) throws URISyntaxException {
    URI dbUri = new URI(databaseUrl);

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setJdbcUrl(dbUrl);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    return dataSource;
  }

}
