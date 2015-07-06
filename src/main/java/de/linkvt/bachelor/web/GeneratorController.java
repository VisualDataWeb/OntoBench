package de.linkvt.bachelor.web;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.axioms.RdfsSubClassOfFeature;
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
    return applicationContext.getBean(OntologyGenerator.class);
  }

  private List<Feature> getFeatures() {
    List<Feature> features = new ArrayList<>();

    features.add(new RdfsSubClassOfFeature());

    return features;
  }
}
