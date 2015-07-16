package de.linkvt.bachelor.web.converters.parameter;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureComparator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StringToFeaturesConverter implements Converter<String, List<Feature>> {

  private FeatureParameterMapping mapping;

  @Autowired
  public StringToFeaturesConverter(FeatureParameterMapping mapping) {
    this.mapping = mapping;
  }

  @Override
  public List<Feature> convert(String query) {
    if (StringUtils.isEmpty(query)) {
      return Collections.emptyList();
    }

    List<String> parameters = getParameters(query);
    List<Feature> features = new ArrayList<>();
    for (String parameter : parameters) {
      Feature feature = mapping.get(parameter);

      if (feature != null) {
        features.add(feature);
      }
    }

    normalizeFeatureOrder(features);

    return Collections.unmodifiableList(features);
  }

  private void normalizeFeatureOrder(List<Feature> features) {
    Collections.sort(features, new FeatureComparator());
  }

  private List<String> getParameters(String query) {
    String lowerCaseQuery = query.toLowerCase();
    return Arrays.asList(lowerCaseQuery.split(","));
  }
}
