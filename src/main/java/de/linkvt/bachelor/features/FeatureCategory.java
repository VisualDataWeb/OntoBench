package de.linkvt.bachelor.features;

/**
 * The category a feature belongs to.
 */
public enum FeatureCategory {
  CLASS_EXPRESSIONS("Predefined Classes, Boolean Connectives and Enumerations"),
  CLASS_EXPRESSION_AXIOMS("Class Expression Axioms"),
  OBJECT_PROPERTIES("Object Properties and Axioms"),
  OBJECT_PROPERTY_RESTRICTIONS("Object Property Restrictions"),
  DATA_PROPERTIES("Data Properties and Axioms"),
  DATA_PROPERTY_RESTRICTIONS("Data Property Restrictions"),
  PROPERTY_EXPRESSIONS("Property Expressions"),
  DATA_RANGE_EXPRESSIONS("Data Range Expressions"),
  INDIVIDUALS("Individuals"),
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
