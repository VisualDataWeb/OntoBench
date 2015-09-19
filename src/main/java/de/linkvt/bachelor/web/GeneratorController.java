package de.linkvt.bachelor.web;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.generator.OntologyGenerator;
import de.linkvt.bachelor.persistence.StoredFeature;
import de.linkvt.bachelor.persistence.StoredGeneration;
import de.linkvt.bachelor.persistence.StoredGenerationRepository;
import de.linkvt.bachelor.presets.Preset;
import de.linkvt.bachelor.web.converters.message.OntologySyntax;
import de.linkvt.bachelor.web.converters.parameter.FeatureParameterMapping;
import de.linkvt.bachelor.web.dtos.FeatureCategoryDto;
import de.linkvt.bachelor.web.dtos.FeatureDto;
import de.linkvt.bachelor.web.dtos.FormatDto;
import de.linkvt.bachelor.web.dtos.PresetDto;

import org.apache.commons.collections4.ListUtils;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
  public OWLOntology completeOntology(HttpServletResponse response) throws OWLOntologyCreationException {
    return ontologyFromParameters(response, featureMapping.getAll());
  }

  @RequestMapping(value = "/ontology/", params = "features")
  public OWLOntology ontologyFromParameters(HttpServletResponse response, @RequestParam("features") List<Feature> features) {
    return ontologyFromParametersWithFilename(response, features);
  }

  @RequestMapping(value = "/ontology/{filename}", params = "features", method = RequestMethod.GET)
  public OWLOntology ontologyFromParametersWithFilename(HttpServletResponse response, @RequestParam("features") List<Feature> features) {
    OntologyGenerator generator = applicationContext.getBean(OntologyGenerator.class);
    RequestInformation information = applicationContext.getBean(RequestInformation.class);

    StoredGeneration generation = storeGenerationIfRequired(features, information);
    response.addHeader("Short-Path", "/ontology/" + generation.getId() + "/" + generation.getId());

    information.setGenerationId(generation.getId());

    generator.addFeatures(features);
    return generator.generate();
  }

  private StoredGeneration storeGenerationIfRequired(@RequestParam("features") List<Feature> features, RequestInformation information) {
    List<StoredFeature> storedFeatures = features.stream().map(StoredFeature::new).collect(Collectors.toList());
    ArrayList<StoredGeneration> generations = new ArrayList<>();
    repository.findAll().forEach(generations::add);
    StoredGeneration generation = generations.stream()
        .filter(g -> ListUtils.isEqualList(g.getParameters(), storedFeatures))
        .findFirst()
        .orElse(null);

    if (generation == null) {
      generation = repository.save(new StoredGeneration(storedFeatures));
    }

    return generation;
  }

  @RequestMapping("/ontology/{id}/")
  public OWLOntology ontologyFromId(HttpServletResponse response, @PathVariable("id") Long id) {
    return ontologyFromIdWithFilename(response, id);
  }

  @RequestMapping("/ontology/{id}/{filename}")
  public OWLOntology ontologyFromIdWithFilename(HttpServletResponse response, @PathVariable("id") Long id) {
    StoredGeneration storedGeneration = repository.findOne(id);
    if (storedGeneration == null) {
      throw new IllegalArgumentException("No generation stored for the passed id.");
    }

    List<Feature> usedFeatures = featureMapping.get(storedGeneration.getParameters().stream().map(StoredFeature::getToken).collect(Collectors.toList()));
    return ontologyFromParameters(response, usedFeatures);
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

  @RequestMapping("/presets")
  public List<PresetDto> presets() {
    Collection<Preset> presets = applicationContext.getBeansOfType(Preset.class).values();

    return presets.stream().map(PresetDto::new).collect(Collectors.toList());
  }

}
