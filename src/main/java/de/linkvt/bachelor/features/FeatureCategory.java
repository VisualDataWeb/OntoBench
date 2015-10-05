package de.linkvt.bachelor.features;

/**
 * The category a feature belongs to.
 */
public enum FeatureCategory {
  PREDEFINED_CLASSES("Predefined and Named Classes"),
  CONNECTIVES_AND_ENUMERATION("Boolean Connectives and Enumeration"),
  OBJECT_PROPERTY_RESTRICTIONS("Object Property Restrictions"),
  DATA_PROPERTY_RESTRICTIONS("Data Property Restrictions"),
  PROPERTY_EXPRESSIONS("Property Expressions"),
  INDIVIDUALS("Individuals"),
  DATA_RANGE_EXPRESSIONS("Data Range Expressions"),
  CLASS_EXPRESSION_AXIOMS("Class Expression Axioms"),
  OBJECT_PROPERTY_AXIOMS("Object Property Axioms"),
  DATA_PROPERTY_AXIOMS("Data Property Axioms"),
  ASSERTIONS("Assertions"),
  KEYS("Keys"),
  DECLARATIONS("Declarations"),
  ANNOTATIONS("Annotations"),
  DC("DC & DC Terms Annotations"),
  SPECIAL_TEST_CASES("Special Test Cases");

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
