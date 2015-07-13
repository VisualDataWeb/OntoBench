package de.linkvt.bachelor.web;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.OntologyGenerator;
import de.linkvt.bachelor.web.converters.parameter.FeatureParameterMapping;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    OntologyGenerator generator = getBean(OntologyGenerator.class);
    FeatureParameterMapping mapping = getBean(FeatureParameterMapping.class);

    // TODO replace with parsing of url
    List<Feature> featureList = mapping.getAll().stream().map(this::getBean).collect(Collectors.toList());
    generator.addFeatures(featureList);

    return generator.generate();
  }

  private <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

}
