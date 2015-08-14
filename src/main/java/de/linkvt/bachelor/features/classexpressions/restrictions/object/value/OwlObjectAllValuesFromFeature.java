package de.linkvt.bachelor.features.classexpressions.restrictions.object.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectAllValuesFromFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasMaker = featurePool.getExclusiveProperty(":hasMaker");

    OWLClass winery = featurePool.getExclusiveClass(":Winery");
    OWLClass wine = featurePool.getExclusiveClass(":Wine");
    OWLObjectAllValuesFrom restriction = factory.getOWLObjectAllValuesFrom(hasMaker, winery);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(wine, restriction));
  }

  @Override
  public String getName() {
    return "owl:allValuesFrom (Object Property)";
  }

  @Override
  public String getToken() {
    return "allvaluesclassobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
