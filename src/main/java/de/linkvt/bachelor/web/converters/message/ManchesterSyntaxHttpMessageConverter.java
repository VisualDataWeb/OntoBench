package de.linkvt.bachelor.web.converters.message;

import org.semanticweb.owlapi.formats.ManchesterSyntaxDocumentFormat;

/**
 * Converts ontologies to the manchester syntax.
 */
public class ManchesterSyntaxHttpMessageConverter extends OntologyHttpMessageConverter {
  public ManchesterSyntaxHttpMessageConverter() {
    super(new ManchesterSyntaxDocumentFormat(), OwlMediaType.TEXT_OWL_MANCHESTER);
  }
}
