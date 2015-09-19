package de.linkvt.bachelor.config;

import org.springframework.stereotype.Component;

/**
 * Extracts the ontology IRI from the URL.
 */
@Component
public class OntologyIriExtractor {

  public String extractOntologyIri(String url, Long generationId) {
    String urlWithoutFilename = trimFilename(url);

    return urlWithoutFilename + generationId + "/";
  }

  private String trimFilename(String url) {
    return url.replaceAll("[^/]+$", "");
  }
}
