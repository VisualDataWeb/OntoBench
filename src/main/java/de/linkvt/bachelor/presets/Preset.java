package de.linkvt.bachelor.presets;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.web.converters.parameter.FeatureParameterMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

/**
 * Base class for a preset
 */
public abstract class Preset {

  @Autowired
  protected FeatureParameterMapping featureMapping;

  @Autowired
  private ApplicationContext context;

  private Set<Feature> features = new HashSet<>();

  public Preset() {

  }

  @SafeVarargs
  protected final Preset addFeatures(Class<? extends Feature>... classes) {
    addFeatures(Arrays.asList(classes));
    return this;
  }

  protected final Preset addFeatures(Collection<Class<? extends Feature>> classes) {
    classes.stream().map(context::getBean).forEach(this.features::add);
    return this;
  }

  public Collection<Feature> getFeatures() {
    return features;
  }

  @PostConstruct
  protected abstract void initialize();

  public abstract String getName();

  public abstract int getIndex();
}
