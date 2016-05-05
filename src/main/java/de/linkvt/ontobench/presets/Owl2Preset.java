package de.linkvt.ontobench.presets;

import de.linkvt.ontobench.features.Feature;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Owl2Preset extends Preset {

  protected void addCompatibleOwl2DatatypeFeatures(List<OWL2Datatype> datatypes) {
    List<String> datatypeIris = datatypes.stream()
        .map(OWL2Datatype::getPrefixedName)
        .collect(Collectors.toList());

    List<Class<? extends Feature>> datatypeClasses = featureMapping.getAll().stream()
        .filter(f -> datatypeIris.contains(f.getName()))
        .map(Feature::getClass)
        .collect(Collectors.toList());

    addFeatures(datatypeClasses);
  }

}
