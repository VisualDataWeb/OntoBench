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
  DATA_RANGES("Data Ranges"),
  INDIVIDUALS("Individuals"),
  ASSERTIONS("Assertions"),
  KEYS("Keys"),
  DECLARATIONS("Declarations"),
  ANNOTATIONS("OWL Annotations"),
  DC("DC & DC Terms Annotations", false),
  SPECIAL_TEST_CASES("Special Test Cases", false);

  private String name;
  private boolean owlSpecific;

  FeatureCategory(String name) {
    this(name, true);
  }

  FeatureCategory(String name, boolean owlSpecific) {
    this.name = name;
    this.owlSpecific = owlSpecific;
  }

  public String getName() {
    return name;
  }

  public boolean isOwlSpecific() {
    return owlSpecific;
  }

  @Override
  public String toString() {
    return getName();
  }
}
