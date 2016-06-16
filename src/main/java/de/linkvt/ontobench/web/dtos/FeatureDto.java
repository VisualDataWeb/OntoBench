package de.linkvt.ontobench.web.dtos;

import de.linkvt.ontobench.features.Feature;

/**
 * Contains all feature informations the REST api consumers need of a {@link Feature}.
 */
public class FeatureDto {
  private String token;
  private String name;
  private String clarification;
  private String compliance;
  private String category;
  private boolean specialization;

  public FeatureDto() {
  }

  public FeatureDto(Feature feature) {
    this.token = feature.getToken();
    this.name = feature.getName();
    this.clarification = feature.getClarification();
    this.compliance = feature.getCompliance();
    this.category = feature.getCategory().getName();
    this.specialization = feature.isSpecialization();
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClarification() {
    return clarification;
  }

  public void setClarification(String clarification) {
    this.clarification = clarification;
  }

  public String getCompliance() {
    return compliance;
  }

  public void setCompliance(String compliance) {
    this.compliance = compliance;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public boolean isSpecialization() {
    return specialization;
  }

  public void setSpecialization(boolean specialization) {
    this.specialization = specialization;
  }
}
