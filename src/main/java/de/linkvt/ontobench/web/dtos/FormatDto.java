package de.linkvt.ontobench.web.dtos;

import de.linkvt.ontobench.web.converters.message.OntologySyntax;

/**
 * Contains all format informations the REST api consumers need.
 */
public class FormatDto {
  private String extension;
  private String name;
  private boolean isDefault;

  public FormatDto() {
  }

  public FormatDto(OntologySyntax format) {
    this.extension = format.getExtension();
    this.name = format.getDocumentFormat().getKey();
    this.isDefault = format.isDefault();
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public void setIsDefault(boolean isDefault) {
    this.isDefault = isDefault;
  }
}
