package de.linkvt.bachelor.web;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.axioms.RdfsSubClassOfFeature;
import de.linkvt.bachelor.features.classes.OwlClassFeature;
import de.linkvt.bachelor.features.classes.OwlDeprecatedClass;
import de.linkvt.bachelor.features.classes.OwlNothingFeature;
import de.linkvt.bachelor.features.classes.OwlThingFeature;
import de.linkvt.bachelor.features.properties.DomainlessPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlDeprecatedPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlEquivalentPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlFunctionalPropertyFeature;
import de.linkvt.bachelor.features.properties.OwlObjectPropertyFeature;
import de.linkvt.bachelor.features.properties.RangelessPropertyFeature;
import de.linkvt.bachelor.features.properties.UnboundPropertyFeature;
import de.linkvt.bachelor.generator.OntologyGenerator;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneratorController {

  private ApplicationContext applicationContext;

  @Autowired
  public GeneratorController(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @RequestMapping(value = "/ontology")
  public OWLOntology ontology() throws OWLOntologyCreationException {
    return ontology(null);
  }

  @RequestMapping(value = "/ontology/{id}")
  public OWLOntology ontology(@PathVariable String id) throws OWLOntologyCreationException {
    OntologyGenerator generator = createGenerator();

    // TODO replace with parsing of url
    generator.addFeatures(getFeatures());

    return generator.generate();
  }

  private OntologyGenerator createGenerator() {
    return getBean(OntologyGenerator.class);
  }

  private <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  private List<Feature> getFeatures() {
    List<Feature> features = new ArrayList<>();

    features.add(getBean(OwlClassFeature.class));
    features.add(getBean(OwlDeprecatedClass.class));
    features.add(getBean(OwlThingFeature.class));
    features.add(getBean(OwlNothingFeature.class));

    features.add(getBean(RdfsSubClassOfFeature.class));

    features.add(getBean(OwlObjectPropertyFeature.class));
    features.add(getBean(OwlDeprecatedPropertyFeature.class));
    features.add(getBean(OwlFunctionalPropertyFeature.class));
    features.add(getBean(OwlEquivalentPropertyFeature.class));
    features.add(getBean(DomainlessPropertyFeature.class));
    features.add(getBean(RangelessPropertyFeature.class));
    features.add(getBean(UnboundPropertyFeature.class));

    return features;
  }
}
