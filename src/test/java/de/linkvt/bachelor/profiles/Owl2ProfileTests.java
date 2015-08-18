package de.linkvt.bachelor.profiles;

import de.linkvt.bachelor.Application;
import de.linkvt.bachelor.generator.OntologyGenerator;
import de.linkvt.bachelor.presets.Owl2ElPreset;
import de.linkvt.bachelor.presets.Owl2QlPreset;
import de.linkvt.bachelor.presets.Owl2RlPreset;
import de.linkvt.bachelor.presets.Preset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.profiles.OWL2ELProfile;
import org.semanticweb.owlapi.profiles.OWL2QLProfile;
import org.semanticweb.owlapi.profiles.OWL2RLProfile;
import org.semanticweb.owlapi.profiles.OWLProfile;
import org.semanticweb.owlapi.profiles.OWLProfileViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class Owl2ProfileTests {

  @Autowired
  private Owl2ElPreset owl2ElPreset;

  @Autowired
  private Owl2QlPreset owl2QlPreset;

  @Autowired
  private Owl2RlPreset owl2RlPreset;

  @Autowired
  private OntologyGenerator generator;


  @Test
  public void testOwl2ElProfile() {
    testPreset(owl2ElPreset, new OWL2ELProfile());
  }

  @Test
  public void testOwl2QlProfile() {
    testPreset(owl2QlPreset, new OWL2QLProfile());
  }

  @Test
  public void testOwl2RlProfile() {
    testPreset(owl2RlPreset, new OWL2RLProfile());
  }

  private void testPreset(Preset preset, OWLProfile profile) {
    generator.addFeatures(preset.getFeatures());
    OWLOntology ontology = generator.generate();

    List<OWLProfileViolation> violations = profile.checkOntology(ontology).getViolations()
        .stream()
        .filter(v -> !v.getClass().getSimpleName().startsWith("UseOfUndeclared"))
        .collect(Collectors.toList());

    assertThat(violations, is(empty()));
  }
}
