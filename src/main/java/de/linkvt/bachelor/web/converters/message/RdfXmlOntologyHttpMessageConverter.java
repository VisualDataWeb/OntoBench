package de.linkvt.bachelor.web.converters.message;

/**
 * Converts ontologies to the rdf/xml format.
 */
public class RdfXmlOntologyHttpMessageConverter extends OntologyHttpMessageConverter {
  public RdfXmlOntologyHttpMessageConverter() {
    super(OntologySyntax.RDF_XML);
  }
}
