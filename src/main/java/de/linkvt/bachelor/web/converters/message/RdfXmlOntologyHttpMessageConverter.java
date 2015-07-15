package de.linkvt.bachelor.web.converters.message;

import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat;

/**
 * Converts ontologies to the rdf/xml format.
 */
public class RdfXmlOntologyHttpMessageConverter extends OntologyHttpMessageConverter {
  public RdfXmlOntologyHttpMessageConverter() {
    super(new RDFXMLDocumentFormat(), OwlMediaType.APPLICATION_RDF_XML);
  }
}
