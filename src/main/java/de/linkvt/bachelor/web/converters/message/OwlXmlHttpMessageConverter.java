package de.linkvt.bachelor.web.converters.message;

import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;

/**
 * Converts ontologies to the owl xml syntax.
 */
public class OwlXmlHttpMessageConverter extends OntologyHttpMessageConverter {
  public OwlXmlHttpMessageConverter() {
    super(new OWLXMLDocumentFormat(), OwlMediaType.APPLICATION_OWL_XML);
  }
}
