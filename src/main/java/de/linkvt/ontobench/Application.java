package de.linkvt.ontobench;

import de.linkvt.ontobench.config.OwlApiConfig;
import de.linkvt.ontobench.config.PersistenceConfig;
import de.linkvt.ontobench.config.WebMvcConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * The entry point of the application.
 */
@SpringBootApplication
@Import({WebMvcConfig.class, OwlApiConfig.class, PersistenceConfig.class})
public class Application extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(Application.class);
  }
}
