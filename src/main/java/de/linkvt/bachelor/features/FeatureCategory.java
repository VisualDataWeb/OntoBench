package de.linkvt.bachelor.features;

/**
 * The category a feature belongs to.
 */
public enum FeatureCategory {
  CLASS("Class"),
  PROPERTY("Property");

  private String description;

  FeatureCategory(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return getDescription();
  }
}
