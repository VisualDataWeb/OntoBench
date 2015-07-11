package de.linkvt.bachelor.web.converters.parameter;

import de.linkvt.bachelor.features.Feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Base class for mapping parameters to features.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class FeatureParameterMapping {
  private Map<String, Feature> featureMap = new HashMap<>();

  @Autowired
  public FeatureParameterMapping(ApplicationContext context) {
    List<Feature> parameterFeatures = getParameterFeatures(context);

    for (Feature feature : parameterFeatures) {
      ParameterName parameterName = feature.getClass().getAnnotation(ParameterName.class);
      register(parameterName.value(), feature);
    }
  }

  private List<Feature> getParameterFeatures(ApplicationContext context) {
    Collection<Object> parameters = context.getBeansWithAnnotation(ParameterName.class).values();
    List<Feature> features = parameters.stream()
        .filter(obj -> obj instanceof Feature)
        .map(obj -> (Feature) obj)
        .collect(Collectors.toList());

    return features;
  }

  private void register(String parameter, Feature feature) {
    if (featureMap.containsKey(parameter)) {
      throw new IllegalArgumentException("Parameter already in use.");
    }
    featureMap.put(parameter, feature);
  }

  public Feature get(String parameter) {
    return featureMap.get(parameter);
  }

  public List<Feature> getAll() {
    List<Feature> features = featureMap.values().stream().collect(Collectors.toList());
    return Collections.unmodifiableList(features);
  }
}
