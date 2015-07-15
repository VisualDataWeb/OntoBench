package de.linkvt.bachelor.web.converters.message;

import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;

/**
 * Converts ontologies to the functional syntax.
 */
public class FunctionalSyntaxHttpMessageConverter extends OntologyHttpMessageConverter {
  public FunctionalSyntaxHttpMessageConverter() {
    super(new FunctionalSyntaxDocumentFormat(), OwlMediaType.TEXT_OWL_FUNCTIONAL);
  }
}
