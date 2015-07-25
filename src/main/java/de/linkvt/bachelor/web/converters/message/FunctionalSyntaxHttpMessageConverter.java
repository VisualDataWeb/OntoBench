package de.linkvt.bachelor.web.converters.message;

/**
 * Converts ontologies to the functional syntax.
 */
public class FunctionalSyntaxHttpMessageConverter extends OntologyHttpMessageConverter {
  public FunctionalSyntaxHttpMessageConverter() {
    super(OntologySyntax.FUNCTIONAL);
  }
}
