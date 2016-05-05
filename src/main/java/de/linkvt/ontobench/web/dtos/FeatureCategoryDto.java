package de.linkvt.ontobench.web.dtos;

import de.linkvt.ontobench.features.FeatureCategory;

/**
 * Contains all category informations the REST api consumers need.
 */
public class FeatureCategoryDto {
  private String name;
  private int index;
  private boolean owlSpecific;

  public FeatureCategoryDto() {
  }

  public FeatureCategoryDto(FeatureCategory category) {
    this.name = category.getName();
    this.index = category.ordinal();
    this.owlSpecific = category.isOwlSpecific();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOwlSpecific() {
    return owlSpecific;
  }

  public void setOwlSpecific(boolean owlSpecific) {
    this.owlSpecific = owlSpecific;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
