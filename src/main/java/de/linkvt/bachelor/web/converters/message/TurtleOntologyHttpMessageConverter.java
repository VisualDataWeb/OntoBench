package de.linkvt.bachelor.web.converters.message;

import org.springframework.http.MediaType;

/**
 * Converts ontologies to the turtle format.
 */
public class TurtleOntologyHttpMessageConverter extends OntologyHttpMessageConverter {
  public TurtleOntologyHttpMessageConverter() {
    super(OntologySyntax.TURTLE, MediaType.TEXT_PLAIN);
  }
}
