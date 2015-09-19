package de.linkvt.bachelor.config;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureComparator;
import de.linkvt.bachelor.generator.OntologyGenerator;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Extracts the ontology IRI from the URL.
 */
@Component
public class OntologyIriExtractor {

  private static final Pattern ONTOLOGY_PATH_PATTERN = Pattern.compile(".*/(\\w+)/.*$", Pattern.CASE_INSENSITIVE);

  public String extractOntologyIri(String url, OntologyGenerator generator) {
    String urlWithoutFilename = trimFilename(url);

    if (isShortUrl(urlWithoutFilename)) {
      return urlWithoutFilename;
    } else {
      return createRandomShortUrl(urlWithoutFilename, generator);
    }
  }

  private String trimFilename(String url) {
    return url.replaceAll("[^/]+$", "");
  }

  private boolean isShortUrl(String url) {
    Matcher matcher = ONTOLOGY_PATH_PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Can't extract ontology IRI from URL: " + url);
    }

    String possibleId = matcher.group(1);

    return NumberUtils.isNumber(possibleId);
  }

  private String createRandomShortUrl(String url, OntologyGenerator generator) {
    SortedSet<Feature> features = new TreeSet<>(new FeatureComparator());
    features.addAll(generator.getFeatures());
    String featureString = features.stream().map(Feature::getToken).collect(Collectors.joining(","));

    String shortUrl = url;
    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(featureString.getBytes());
      shortUrl += "tmp/" + String.valueOf(Hex.encodeHex(digest.digest())) + "/";
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return shortUrl;
  }
}
