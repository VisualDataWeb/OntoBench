/*
 * Main.java
 *
 */

package de.linkvt.bachelor;

import de.linkvt.bachelor.output.ConsoleExporter;
import de.linkvt.bachelor.output.Exporter;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.TurtleDocumentFormat;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.*;

/**
 * The entry point of the application.
 */
public class Main {

	private static Exporter exporter = new ConsoleExporter();

	public static void main(String[] args) {
		System.out.println("Application started.");

		try {
			printSimpleOntology();
		} catch (OWLOntologyCreationException | OWLOntologyStorageException e) {
			e.printStackTrace();
		}
	}

	private static void printSimpleOntology()
			throws OWLOntologyCreationException, OWLOntologyStorageException {
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLDataFactory factory = ontologyManager.getOWLDataFactory();
		OWLOntology ontology = ontologyManager.createOntology();

		OWLClass superClass = factory.getOWLClass(IRI.create("SuperClass"));
		OWLClass subClass = factory.getOWLClass(IRI.create("SubClass"));
		OWLAxiom axiom = factory.getOWLSubClassOfAxiom(subClass, superClass);
		ontologyManager.applyChange(new AddAxiom(ontology, axiom));

		StringDocumentTarget target = new StringDocumentTarget();
		ontology.saveOntology(new TurtleDocumentFormat(), target);

		try {
			exporter.export(target.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
