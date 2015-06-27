package de.linkvt.bachelor.document;

import org.semanticweb.owlapi.formats.RDFXMLDocumentFormat;
import org.semanticweb.owlapi.formats.TurtleDocumentFormat;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores format names and the matching OWL document format.
 */
public class DocumentFormats {
	private static Map<String, OWLDocumentFormat> documentFormatMap = new HashMap<>();

	static {
		documentFormatMap.put("turtle", new TurtleDocumentFormat());
		documentFormatMap.put("rdf", new RDFXMLDocumentFormat());
	}

	public static OWLDocumentFormat fromName(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("Format name must not be null or empty.");
		}

		return documentFormatMap.get(name.toLowerCase());
	}
}
