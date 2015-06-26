package de.linkvt.bachelor;

import de.linkvt.bachelor.document.DocumentBuilder;
import de.linkvt.bachelor.generator.OntologyGenerator;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * The entry point of the application.
 */
public class Main {

	public static void main(String[] args) {
		printSimpleOntology();
	}

	private static void printSimpleOntology() {
		try {
			OWLOntology ontology = new OntologyGenerator().generate();
			String text = new DocumentBuilder(ontology).inTurtle().asString();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
