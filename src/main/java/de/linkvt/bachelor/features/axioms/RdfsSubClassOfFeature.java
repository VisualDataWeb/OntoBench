package de.linkvt.bachelor.features.axioms;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * The rdfs:subClassOf axiom.
 */
public class RdfsSubClassOfFeature extends Feature {

  @Override
  public void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLClass superClass = featurePool.getNewClass("SuperClass");
    OWLClass subClass = featurePool.getNewClass("SubClass");
    OWLAxiom subClassOfAxiom = factory.getOWLSubClassOfAxiom(subClass, superClass);

    ontology.getOWLOntologyManager().applyChange(new AddAxiom(ontology, subClassOfAxiom));
  }
}
