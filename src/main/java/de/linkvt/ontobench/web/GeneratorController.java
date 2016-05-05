package de.linkvt.ontobench.web;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;
import de.linkvt.ontobench.generator.OntologyGenerator;
import de.linkvt.ontobench.persistence.StoredFeature;
import de.linkvt.ontobench.persistence.StoredGeneration;
import de.linkvt.ontobench.persistence.StoredGenerationRepository;
import de.linkvt.ontobench.presets.Preset;
import de.linkvt.ontobench.web.converters.message.OntologySyntax;
import de.linkvt.ontobench.web.converters.parameter.FeatureParameterMapping;
import de.linkvt.ontobench.web.dtos.FeatureCategoryDto;
import de.linkvt.ontobench.web.dtos.FeatureDto;
import de.linkvt.ontobench.web.dtos.FormatDto;
import de.linkvt.ontobench.web.dtos.PresetDto;

import org.apache.commons.collections4.CollectionUtils;
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

  public static final String ONTOLOGY_PATH_WITHOUT_SLASH = "ontology";
  public static final String ONTOLOGY_PATH = ONTOLOGY_PATH_WITHOUT_SLASH + "/";

  private ApplicationContext applicationContext;
  private FeatureParameterMapping featureMapping;
  private StoredGenerationRepository repository;

  @Autowired
  public GeneratorController(ApplicationContext applicationContext, FeatureParameterMapping featureMapping, StoredGenerationRepository repository) {
    this.applicationContext = applicationContext;
    this.featureMapping = featureMapping;
    this.repository = repository;
  }

  @RequestMapping(ONTOLOGY_PATH)
  public OWLOntology completeOntology(HttpServletResponse response) throws OWLOntologyCreationException {
    return ontologyFromParameters(response, featureMapping.getAll());
  }

  @RequestMapping(value = ONTOLOGY_PATH, params = "features")
  public OWLOntology ontologyFromParameters(HttpServletResponse response, @RequestParam("features") List<Feature> features) {
    return ontologyFromParametersWithFilename(response, features);
  }

  @RequestMapping(value = ONTOLOGY_PATH + "{filename}", params = "features", method = RequestMethod.GET)
  public OWLOntology ontologyFromParametersWithFilename(HttpServletResponse response, @RequestParam("features") List<Feature> features) {
    OntologyGenerator generator = applicationContext.getBean(OntologyGenerator.class);
    RequestInformation information = applicationContext.getBean(RequestInformation.class);

    StoredGeneration generation = storeGenerationIfRequired(features);
    response.addHeader("Short-Path", "/" + ONTOLOGY_PATH + generation.getId() + "/" + generation.getId());

    information.setGenerationId(generation.getId());

    generator.addFeatures(features);
    return generator.generate();
  }

  private StoredGeneration storeGenerationIfRequired(List<Feature> features) {
    List<StoredFeature> storedFeatures = features.stream().map(Feature::getStoredFeature).collect(Collectors.toList());
    List<StoredGeneration> generations = new ArrayList<>();
    repository.findAll().forEach(generations::add);
    StoredGeneration generation = generations.stream()
        .filter(g -> CollectionUtils.isEqualCollection(g.getParameters(), storedFeatures))
        .findFirst()
        .orElse(null);

    if (generation == null) {
      generation = repository.save(new StoredGeneration(features));
    }

    return generation;
  }

  @RequestMapping(ONTOLOGY_PATH + "{id}/")
  public OWLOntology ontologyFromId(HttpServletResponse response, @PathVariable("id") Long id) {
    return ontologyFromIdWithFilename(response, id);
  }

  @RequestMapping(ONTOLOGY_PATH + "{id}/{filename}")
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
