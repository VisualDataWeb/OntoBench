package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class RdfXmlLiteralFeature extends AbstractDatatypeMapFeature {

  public RdfXmlLiteralFeature() {
    super(OWL2Datatype.RDF_XML_LITERAL);
  }

}
