package de.linkvt.bachelor.web.converters.message;

import org.semanticweb.owlapi.formats.TurtleDocumentFormat;

/**
 * Converts ontologies to the turtle format.
 */
public class TurtleOntologyHttpMessageConverter extends OntologyHttpMessageConverter {
  public TurtleOntologyHttpMessageConverter() {
    super(new TurtleDocumentFormat(), OwlMediaType.TEXT_PLAIN, OwlMediaType.TEXT_TURTLE);
  }
}
