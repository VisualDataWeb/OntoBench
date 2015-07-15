/*
 * MimeType.java
 *
 */

package de.linkvt.bachelor.web.converters.message;

import org.springframework.http.MediaType;

/**
 * Mime types for owl syntaxes.
 */
public class OwlMediaType {

  public static final MediaType APPLICATION_RDF_XML = new MediaType("application", "rdf+xml");
  public static final MediaType TEXT_OWL_FUNCTIONAL = new MediaType("text", "owl-functional");
  public static final MediaType TEXT_OWL_MANCHESTER = new MediaType("text", "owl-manchester");
  public static final MediaType TEXT_TURTLE = new MediaType("text", "turtle");

  private OwlMediaType() {
  }
}
