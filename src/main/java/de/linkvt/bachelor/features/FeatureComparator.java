package de.linkvt.bachelor.features;

import java.util.Comparator;

/**
 * Custom comparator for features. Some general features should be created before more specific features.
 */
public class FeatureComparator implements Comparator<Feature> {
  @Override
  public int compare(Feature o1, Feature o2) {
    if (o1.isGeneral() && !o2.isGeneral()) {
      return -1;
    } else if (!o1.isGeneral() && o2.isGeneral()) {
      return 1;
    } else {
      return o1.getToken().compareTo(o2.getToken());
    }
  }
}
