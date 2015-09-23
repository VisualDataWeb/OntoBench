package de.linkvt.bachelor.config;

import org.springframework.stereotype.Component;

/**
 * Extracts the ontology IRI from the URL.
 */
@Component
public class OntologyIriExtractor {

  public String extractOntologyIri(String url, Long generationId) {
    String urlWithoutFilename = trimFilenameAndId(url);

    return urlWithoutFilename + generationId + "/";
  }

  private String trimFilenameAndId(String url) {
    return url.replaceAll("(\\d+/)?[^/]+$", "");
  }
}
