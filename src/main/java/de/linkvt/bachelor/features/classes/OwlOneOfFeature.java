package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.springframework.stereotype.Component;

/**
 * An owl oneOf feature.
 */
@Component
public class OwlOneOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual fork = factory.getOWLNamedIndividual(IRI.create("Fork"));
    OWLNamedIndividual knife = factory.getOWLNamedIndividual(IRI.create("Knife"));
    OWLNamedIndividual spoon = factory.getOWLNamedIndividual(IRI.create("Spoon"));
    OWLObjectOneOf cutlery = factory.getOWLObjectOneOf(fork, knife, spoon);

    OWLClass oneOfClass = factory.getOWLClass(IRI.create("Cutlery"));

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(oneOfClass, cutlery);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:oneOf";
  }

  @Override
  public String getToken() {
    return "owloneof";
  }
}
