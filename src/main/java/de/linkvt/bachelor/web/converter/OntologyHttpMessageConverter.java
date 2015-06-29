package de.linkvt.bachelor.web.converter;

import org.semanticweb.owlapi.io.OWLOntologyDocumentTarget;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * Converts ontologies to a string for the http message.
 */
public abstract class OntologyHttpMessageConverter extends AbstractHttpMessageConverter<OWLOntology> {
  private final OWLDocumentFormat documentFormat;

  public OntologyHttpMessageConverter(OWLDocumentFormat documentFormat, MediaType... mediaTypes) {
    super(mediaTypes);
    this.documentFormat = documentFormat;
  }

  @Override
  protected boolean supports(Class<?> clazz) {
    return OWLOntology.class.isAssignableFrom(clazz);
  }

  @Override
  protected OWLOntology readInternal(Class<? extends OWLOntology> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
    return null;
  }

  @Override
  protected void writeInternal(OWLOntology ontology, HttpOutputMessage httpOutputMessage)
      throws IOException, HttpMessageNotWritableException {
    OWLOntologyDocumentTarget target = new StringDocumentTarget();

    try {
      ontology.saveOntology(documentFormat, target);
    } catch (OWLOntologyStorageException e) {
      // should not happpen
      throw new IllegalStateException(e);
    }

    httpOutputMessage.getBody().write(target.toString().getBytes());
  }
}
