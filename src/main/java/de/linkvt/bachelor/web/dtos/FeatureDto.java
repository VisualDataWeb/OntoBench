package de.linkvt.bachelor.web.dtos;

import de.linkvt.bachelor.features.Feature;

/**
 * Contains all informations the REST api consumers need.
 */
public class FeatureDto {
  private String token;
  private String name;

  public FeatureDto() {
  }

  public FeatureDto(Feature feature) {
    this.token = feature.getToken();
    this.name = feature.getName();
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
}
