package de.linkvt.ontobench.web.converters.message;

/**
 * Converts ontologies to the turtle format.
 */
public class TurtleOntologyHttpMessageConverter extends OntologyHttpMessageConverter {
  public TurtleOntologyHttpMessageConverter() {
    super(OntologySyntax.TURTLE);
  }
}
