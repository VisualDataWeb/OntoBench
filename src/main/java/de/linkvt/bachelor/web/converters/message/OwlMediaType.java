/*
 * MimeType.java
 *
 */

package de.linkvt.bachelor.web.converters.message;

import org.springframework.http.MediaType;

/**
 * Mime types for owl syntaxes.
 */
public final class OwlMediaType extends MediaType {

  public static final MediaType APPLICATION_RDF_XML = valueOf("application/rdf+xml");
  public static final MediaType TEXT_TURTLE = valueOf("text/turtle");

  public OwlMediaType(String type) {
    super(type);
  }
}
