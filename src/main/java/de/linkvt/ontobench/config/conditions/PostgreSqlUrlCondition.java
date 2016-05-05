package de.linkvt.ontobench.config.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Checks whether the DATABASE_URL environment variable is available.
 */
public class PostgreSqlUrlCondition implements Condition {
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return context.getEnvironment().getProperty("DATABASE_URL") != null;
  }
}
