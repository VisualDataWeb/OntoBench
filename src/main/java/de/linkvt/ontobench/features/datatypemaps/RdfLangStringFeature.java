package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class RdfLangStringFeature extends AbstractDatatypeMapFeature {

  public RdfLangStringFeature() {
    super(OWL2Datatype.RDF_LANG_STRING);
  }

}
