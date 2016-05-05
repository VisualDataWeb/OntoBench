package de.linkvt.ontobench.web.converters.message;

/**
 * Converts ontologies to the functional syntax.
 */
public class FunctionalSyntaxHttpMessageConverter extends OntologyHttpMessageConverter {
  public FunctionalSyntaxHttpMessageConverter() {
    super(OntologySyntax.FUNCTIONAL);
  }
}
