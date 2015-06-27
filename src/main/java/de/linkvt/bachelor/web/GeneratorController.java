package de.linkvt.bachelor.web;

import de.linkvt.bachelor.document.DocumentBuilder;
import de.linkvt.bachelor.document.DocumentFormats;
import de.linkvt.bachelor.generator.OntologyGenerator;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController public class GeneratorController {

	@RequestMapping(value = "/generator", produces = MediaType.TEXT_PLAIN_VALUE)
	public String ontology(@RequestParam(defaultValue = "turtle") String format) {
		String ontologyAsText = null;

		try {
			OWLDocumentFormat documentFormat = DocumentFormats.fromName(format);
			OWLOntology ontology = new OntologyGenerator().generate();

			ontologyAsText = new DocumentBuilder(ontology, documentFormat).asString();
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
