package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class RdfPlainLiteralFeature extends AbstractDatatypeMapFeature {

  public RdfPlainLiteralFeature() {
    super(OWL2Datatype.RDF_PLAIN_LITERAL);
  }

}
