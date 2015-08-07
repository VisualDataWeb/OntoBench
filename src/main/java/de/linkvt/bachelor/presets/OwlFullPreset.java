package de.linkvt.bachelor.presets;

import org.springframework.stereotype.Component;

@Component
public class OwlFullPreset extends OwlDlPreset {
  @Override
  protected void initialize() {
    super.initialize();
  }

  @Override
  public String getName() {
    return "OWL Full (WIP)";
  }

  @Override
  public int getIndex() {
    return 2;
  }
}
