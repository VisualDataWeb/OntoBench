package de.linkvt.bachelor.web.dtos;

import de.linkvt.bachelor.web.converters.message.OntologySyntax;

/**
 * Contains all informations the REST api consumers need.
 */
public class FormatDto {
  private String extension;
  private String name;

  public FormatDto() {
  }

  public FormatDto(OntologySyntax format) {
    this.extension = format.getExtension();
    this.name = format.getDocumentFormat().getKey();
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
}
