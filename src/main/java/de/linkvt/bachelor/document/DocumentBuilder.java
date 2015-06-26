package de.linkvt.bachelor.document;

import org.semanticweb.owlapi.formats.TurtleDocumentFormat;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 * Formats an ontology in a specified format to the specified target.
 */
public class DocumentBuilder {
	private OWLOntology ontology;
	private OWLDocumentFormat documentFormat;

	public DocumentBuilder(OWLOntology ontology) {
		if (ontology == null) {
			throw new IllegalStateException("Ontology must not be null");
		}
		this.ontology = ontology;
	}

	public DocumentBuilder inTurtle() {
		documentFormat = new TurtleDocumentFormat();
		return this;
	}

	public String asString() throws OWLOntologyStorageException {
		StringDocumentTarget target = new StringDocumentTarget();
		ontology.saveOntology(documentFormat, target);
		return target.toString();
	}
}
