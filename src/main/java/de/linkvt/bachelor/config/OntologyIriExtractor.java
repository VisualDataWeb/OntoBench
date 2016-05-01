package de.linkvt.bachelor.config;

import de.linkvt.bachelor.web.GeneratorController;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Extracts the ontology IRI from the URL.
 */
@Component
public class OntologyIriExtractor {

  public String extractGeneratorIri(String url) {
    String urlWithoutIdAndFilename = trimFilenameAndId(url);

    return removeOntologyPath(urlWithoutIdAndFilename);
  }

  public String extractOntologyIri(String url, Long generationId) {
    String urlWithoutFilename = trimFilenameAndId(url);

    return urlWithoutFilename + generationId + "/";
  }

  private String trimFilenameAndId(String url) {
    return url.replaceAll("(\\d+/)?[^/]*$", "");
  }

  private String removeOntologyPath(String url) {
    return StringUtils.removeEndIgnoreCase(url, GeneratorController.ONTOLOGY_PATH);
  }

}
