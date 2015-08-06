package de.linkvt.bachelor.web.dtos;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.presets.Preset;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Dto for presets.
 */
public class PresetDto {
  String name;
  Set<String> tokens;

  public PresetDto(Preset preset) {
    this.name = preset.getName();
    this.tokens = preset.getFeatures().stream().map(Feature::getToken).collect(Collectors.toSet());
  }

  public PresetDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getTokens() {
    return tokens;
  }

  public void setTokens(Set<String> tokens) {
    this.tokens = tokens;
  }
}
