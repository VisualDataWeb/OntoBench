package de.linkvt.bachelor.web.converters.parameter;

import de.linkvt.bachelor.features.Feature;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Base class for mapping parameters to features.
 */
@Component
public class FeatureParameterMapping {
  private Map<String, Class<Feature>> featureMap = new HashMap<>();

  public FeatureParameterMapping() {
    List<Class<Feature>> parameterFeatures = getParameterFeatures();

    for (Class<Feature> feature : parameterFeatures) {
      ParameterName parameterName = feature.getAnnotation(ParameterName.class);
      register(parameterName.value(), feature);
    }
  }

  private List<Class<Feature>> getParameterFeatures() {
    Reflections reflections = new Reflections("de.linkvt.bachelor");
    Set<Class<?>> parameters = reflections.getTypesAnnotatedWith(ParameterName.class);

    List<Class<Feature>> features = parameters.stream()
        .filter(Feature.class::isAssignableFrom)
        .map(cls -> (Class<Feature>) cls)
        .collect(Collectors.toList());

    return features;
  }

  private void register(String parameter, Class<Feature> feature) {
    if (featureMap.containsKey(parameter)) {
      throw new IllegalArgumentException("Parameter already in use.");
    }
    featureMap.put(parameter, feature);
  }

  public Class<Feature> get(String parameter) {
    return featureMap.get(parameter);
  }

  public List<Class<Feature>> getAll() {
    List<Class<Feature>> features = featureMap.values().stream().collect(Collectors.toList());
    return Collections.unmodifiableList(features);
  }
}
