package de.linkvt.bachelor.web.converters.parameter;

import de.linkvt.bachelor.features.Feature;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Maps the query string to requested features.
 */
@Component
public class StringToPropertyFeaturesConverter implements Converter<String, List<Feature>> {

  private ApplicationContext context;
  private FeatureParameterMapping mapping;

  @Autowired
  public StringToPropertyFeaturesConverter(ApplicationContext context, FeatureParameterMapping mapping) {
    this.context = context;
    this.mapping = mapping;
  }

  @Override
  public List<Feature> convert(String query) {
    if (StringUtils.isEmpty(query)) {
      return Collections.emptyList();
    }

    List<String> parameters = Arrays.asList(query.split(","));
    List<Feature> features = new ArrayList<>();

    for (String parameter : parameters) {
      Class<Feature> featureClass = mapping.get(parameter);

      if (featureClass != null) {
        features.add(context.getBean(featureClass));
      }
    }

    return Collections.unmodifiableList(features);
  }
}
