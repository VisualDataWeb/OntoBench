package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.Feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

/**
 * Base class for a preset
 */
public abstract class Preset {
  private Set<Feature> features = new HashSet<>();

  @Autowired
  private ApplicationContext context;

  public Preset() {

  }

  protected Preset addFeature(Feature feature) {
    features.add(feature);
    return this;
  }

  protected Preset addFeature(Class<? extends Feature> clazz) {
    features.add(context.getBean(clazz));
    return this;
  }

  public Collection<Feature> getFeatures() {
    return features;
  }

  @PostConstruct
  protected abstract void addFeatures();

  public abstract String getName();
}
