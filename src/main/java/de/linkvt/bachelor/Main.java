package de.linkvt.bachelor;

import de.linkvt.bachelor.document.DocumentBuilder;
import de.linkvt.bachelor.generator.OntologyGenerator;
import org.semanticweb.owlapi.model.OWLOntology;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the application.
 */
@SpringBootApplication() public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
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
