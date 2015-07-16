package de.linkvt.bachelor.web;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.OntologyGenerator;
import de.linkvt.bachelor.web.converters.parameter.FeatureParameterMapping;
import de.linkvt.bachelor.web.dtos.FeatureDto;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GeneratorController {

  private ApplicationContext applicationContext;
  private FeatureParameterMapping featureMapping;

  @Autowired
  public GeneratorController(ApplicationContext applicationContext, FeatureParameterMapping featureMapping) {
    this.applicationContext = applicationContext;
    this.featureMapping = featureMapping;
  }

  @RequestMapping("/ontology")
  public OWLOntology ontology() throws OWLOntologyCreationException {
    return ontology(featureMapping.getAll());
  }

  @RequestMapping(value = "/ontology", params = {"features"})
  public OWLOntology ontology(@RequestParam("features") List<Feature> features) {
    OntologyGenerator generator = getBean(OntologyGenerator.class);

    generator.addFeatures(features);

    return generator.generate();
  }

  private <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  @RequestMapping("/features")
  public List<FeatureDto> features() {
    List<Feature> features = featureMapping.getAll();

    return features.stream().map(FeatureDto::new).collect(Collectors.toList());
  }

}
