package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlRationalFeature extends AbstractDatatypeMapFeature {

  public OwlRationalFeature() {
    super(OWL2Datatype.OWL_RATIONAL);
  }

}
