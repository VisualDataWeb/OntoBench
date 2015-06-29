package de.linkvt.bachelor.generator;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * Evaluates the features and creates the ontology.
 */
public class OntologyGenerator {
  private OWLOntologyManager ontologyManager;
  private OWLDataFactory factory;
  private OWLOntology ontology;

  public OntologyGenerator() throws OWLOntologyCreationException {
    ontologyManager = OWLManager.createOWLOntologyManager();
    factory = ontologyManager.getOWLDataFactory();
    ontology = ontologyManager.createOntology();
  }

  public OWLOntology generate() {
    OWLClass superClass = factory.getOWLClass(IRI.create("SuperClass"));
    OWLClass subClass = factory.getOWLClass(IRI.create("SubClass"));
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(subClass, superClass);
    ontologyManager.applyChange(new AddAxiom(ontology, axiom));

    return ontology;
  }
}
