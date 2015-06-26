package de.linkvt.bachelor.web;

import de.linkvt.bachelor.document.DocumentBuilder;
import de.linkvt.bachelor.generator.OntologyGenerator;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController public class GeneratorController {

	@RequestMapping(value = "/ontology", produces = MediaType.TEXT_PLAIN_VALUE) public String ontology() {
		String ontologyAsText = null;

		try {
			OWLOntology ontology = new OntologyGenerator().generate();
			ontologyAsText = new DocumentBuilder(ontology).inTurtle().asString();
		} catch (OWLOntologyCreationException | OWLOntologyStorageException e) {
			e.printStackTrace();
		}

		if (ontologyAsText != null) {
			return ontologyAsText;
		} else {
			return "Error";
		}
	}

}
