package de.linkvt.bachelor.features;

/**
 * The category a feature belongs to.
 */
public enum FeatureCategory {
  PROPERTY("Properties"),
  CLASS("Classes"),
  ONTOLOGY("Ontology");

  private String name;

  FeatureCategory(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }
}
