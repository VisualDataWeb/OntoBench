package de.linkvt.bachelor.web.converters.message;

import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat;
import org.springframework.http.MediaType;

/**
 * Converts ontologies to the rdf/xml format.
 */
public class RdfXmlOntologyHttpMessageConverter extends OntologyHttpMessageConverter {
  public RdfXmlOntologyHttpMessageConverter() {
    super(new RDFXMLDocumentFormat(), MediaType.TEXT_XML);
  }
}
