package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlRealFeature extends AbstractDatatypeMapFeature {

  public OwlRealFeature() {
    super(OWL2Datatype.OWL_REAL);
  }

}
