/*
 * DocumentFormat.java
 *
 */

package de.linkvt.ontobench.web.converters.message;

import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.ManchesterSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat;
import org.semanticweb.owlapi.formats.TurtleDocumentFormat;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.springframework.http.MediaType;

/**
 * Supported document formats and their extension.
 */
public enum OntologySyntax {
  FUNCTIONAL(new FunctionalSyntaxDocumentFormat(), "ofn", new MediaType("text", "owl-functional")),
  MANCHESTER(new ManchesterSyntaxDocumentFormat(), "omn", new MediaType("text", "owl-manchester")),
  OWL_XML(new OWLXMLDocumentFormat(), "owx", new MediaType("application", "owl+xml")),
  RDF_XML(new RDFXMLDocumentFormat(), "owl", new MediaType("application", "rdf+xml")),
  TURTLE(new TurtleDocumentFormat(), "ttl", new MediaType("text", "turtle"), true);

  private OWLDocumentFormat documentFormat;
  private String extension;
  private MediaType mediaType;
  private boolean isDefault = false;

  private OntologySyntax(OWLDocumentFormat documentFormat, String extension, MediaType mediaType) {
    this(documentFormat, extension, mediaType, false);
  }

  private OntologySyntax(OWLDocumentFormat documentFormat, String extension, MediaType mediaType, boolean isDefault) {
    this.documentFormat = documentFormat;
    this.extension = extension;
    this.mediaType = mediaType;
    this.isDefault = isDefault;
  }

  public OWLDocumentFormat getDocumentFormat() {
    return documentFormat;
  }

  public String getExtension() {
    return extension;
  }

  public MediaType getMediaType() {
    return mediaType;
  }

  public boolean isDefault() {
    return isDefault;
  }
}
