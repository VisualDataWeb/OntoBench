package de.linkvt.ontobench.web.converters.message;

/**
 * Converts ontologies to the owl xml syntax.
 */
public class OwlXmlHttpMessageConverter extends OntologyHttpMessageConverter {
  public OwlXmlHttpMessageConverter() {
    super(OntologySyntax.OWL_XML);
  }
}
