package de.linkvt.bachelor.web;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.generator.OntologyGenerator;
import de.linkvt.bachelor.persistence.StoredGeneration;
import de.linkvt.bachelor.persistence.StoredGenerationRepository;
import de.linkvt.bachelor.web.converters.message.OntologySyntax;
import de.linkvt.bachelor.web.converters.parameter.FeatureParameterMapping;
import de.linkvt.bachelor.web.dtos.FeatureCategoryDto;
import de.linkvt.bachelor.web.dtos.FeatureDto;
import de.linkvt.bachelor.web.dtos.FormatDto;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GeneratorController {

  private ApplicationContext applicationContext;
  private FeatureParameterMapping featureMapping;
  private StoredGenerationRepository repository;

  @Autowired
  public GeneratorController(ApplicationContext applicationContext, FeatureParameterMapping featureMapping, StoredGenerationRepository repository) {
    this.applicationContext = applicationContext;
    this.featureMapping = featureMapping;
    this.repository = repository;
  }

  @RequestMapping("/ontology/")
  public OWLOntology completeOntology() throws OWLOntologyCreationException {
    return ontologyWithFeatures(featureMapping.getAll());
  }

  @RequestMapping(value = "/ontology/", params = "features")
  public OWLOntology ontologyWithFeatures(@RequestParam("features") List<Feature> features) {
    OntologyGenerator generator = applicationContext.getBean(OntologyGenerator.class);

    generator.addFeatures(features);

    return generator.generate();
  }

  @RequestMapping(value = "/ontology/", params = "features", method = RequestMethod.POST)
  public void storeAndRedirect(HttpServletResponse response, @RequestParam("features") List<Feature> features) throws IOException {
    List<String> tokens = features.stream().map(Feature::getToken).collect(Collectors.toList());
    StoredGeneration generation = repository.save(new StoredGeneration(tokens));

    response.sendRedirect("/ontology/" + generation.getId() + "/");
  }

  @RequestMapping(value = "/ontology-store", params = "features", method = RequestMethod.GET)
  public void devStoreAndRedirect(HttpServletResponse response, @RequestParam("features") List<Feature> features) throws IOException {
    storeAndRedirect(response, features);
  }

  @RequestMapping("/ontology/{id}/")
  public OWLOntology ontologyFromId(HttpServletResponse response, @PathVariable("id") Long id) {
    StoredGeneration storedGeneration = repository.findOne(id);
    if (storedGeneration == null) {
      throw new IllegalArgumentException("No generation stored for the passed id.");
    }

    // required because the web app can't tell to which URL the POST request went
    response.addHeader("Short-Path", "/ontology/" + id + "/");

    List<Feature> usedFeatures = featureMapping.get(storedGeneration.getParameters());
    return ontologyWithFeatures(usedFeatures);
  }

  @RequestMapping("/features")
  public List<FeatureDto> features() {
    List<Feature> features = featureMapping.getAll();

    return features.stream().map(FeatureDto::new).collect(Collectors.toList());
  }

  @RequestMapping("/formats")
  public List<FormatDto> formats() {
    List<OntologySyntax> syntaxes = Arrays.asList(OntologySyntax.values());

    return syntaxes.stream().map(FormatDto::new).collect(Collectors.toList());
  }

  @RequestMapping("/categories")
  public List<FeatureCategoryDto> categories() {
    List<FeatureCategory> categories = Arrays.asList(FeatureCategory.values());

    return categories.stream().map(FeatureCategoryDto::new).collect(Collectors.toList());
  }

}
