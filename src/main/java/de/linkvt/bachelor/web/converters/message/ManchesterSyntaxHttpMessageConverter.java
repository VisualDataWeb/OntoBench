package de.linkvt.bachelor.web.converters.message;

/**
 * Converts ontologies to the manchester syntax.
 */
public class ManchesterSyntaxHttpMessageConverter extends OntologyHttpMessageConverter {
  public ManchesterSyntaxHttpMessageConverter() {
    super(OntologySyntax.MANCHESTER);
  }
}
