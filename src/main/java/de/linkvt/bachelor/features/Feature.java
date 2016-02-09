package de.linkvt.bachelor.features;

import de.linkvt.bachelor.generator.FeaturePool;
import de.linkvt.bachelor.persistence.StoredFeature;
import de.linkvt.bachelor.persistence.StoredFeatureRepository;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.PrefixManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Base class for ontology features.
 */
public abstract class Feature {

  @Autowired
  protected OWLDataFactory factory;
  @Autowired
  protected FeaturePool featurePool;
  @Autowired
  protected PrefixManager pm;
  @Autowired
  protected OWLOntology ontology;
  @Autowired
  private StoredFeatureRepository repository;

  private StoredFeature storedFeature;

  @PostConstruct
  private void setupForDatabase() {
    StoredFeature possiblyStoredFeature = repository.findByToken(getToken());
    if (possiblyStoredFeature != null) {
      this.storedFeature = possiblyStoredFeature;
    } else {
      this.storedFeature = repository.save(new StoredFeature(this));
    }
  }

  /**
   * Adds this feature to the passed ontology.
   */
  public abstract void addToOntology();

  protected void addAxiomToOntology(OWLAxiom axiom) {
    ontology.getOWLOntologyManager().addAxiom(ontology, axiom);
  }

  protected void addToGenericDomainAndNewRange(OWLObjectProperty property, OWLClassExpression range) {
    OWLClass domain = featurePool.getReusableClass();
    addProperty(domain, property, range);
  }

  protected void addToGenericDomainAndNewRange(OWLDataProperty property, OWLDataRange range) {
    OWLClass domain = featurePool.getReusableClass();
    addProperty(domain, property, range);
  }

  protected void addProperty(OWLClass domain, OWLObjectProperty property, OWLClassExpression range) {
    addAxiomToOntology(factory.getOWLObjectPropertyDomainAxiom(property, domain));
    addAxiomToOntology(factory.getOWLObjectPropertyRangeAxiom(property, range));
  }

  protected void addProperty(OWLClass domain, OWLDataProperty property, OWLDataRange range) {
    addAxiomToOntology(factory.getOWLDataPropertyDomainAxiom(property, domain));
    addAxiomToOntology(factory.getOWLDataPropertyRangeAxiom(property, range));
  }

  protected void addChangeToOntology(OWLOntologyChange change) {
    ontology.getOWLOntologyManager().applyChange(change);
  }

  /**
   * @return the name of this feature
   */
  public abstract String getName();

  /**
   * @return a clarification of the feature name
   */
  public String getClarification() {
    return null;
  }

  /**
    * @return a description of compliant profiles
   */
  public String getCompliance() {
    return null;
  }

  /**
   * @return the unique token of this feature
   */
  public abstract String getToken();

  /**
   * @return the category of this feature
   */
  public abstract FeatureCategory getCategory();

  /**
   * @return true, if this feature is a base feature
   */
  public boolean isGeneral() {
    return false;
  }

  public StoredFeature getStoredFeature() {
    return storedFeature;
  }

  @Override
  public String toString() {
    return getName();
  }
}
