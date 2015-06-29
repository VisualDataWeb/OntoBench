package de.linkvt.bachelor.web.converter;

import org.semanticweb.owlapi.formats.TurtleDocumentFormat;
import org.springframework.http.MediaType;

/**
 * Converts ontologies to the turtle format.
 */
public class TurtleOntologyHttpMessageConverter extends OntologyHttpMessageConverter {
  public TurtleOntologyHttpMessageConverter() {
    super(new TurtleDocumentFormat(), MediaType.TEXT_PLAIN);
  }
}
