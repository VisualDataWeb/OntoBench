package de.linkvt.bachelor.web.dtos;

import de.linkvt.bachelor.features.FeatureCategory;

/**
 * Contains all category informations the REST api consumers need.
 */
public class FeatureCategoryDto {
  private String name;
  private int index;

  public FeatureCategoryDto() {
  }

  public FeatureCategoryDto(FeatureCategory category) {
    this.name = category.getName();
    this.index = category.ordinal();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
