package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdNonNegativeIntegerFeature extends AbstractDatatypeMapFeature {

  public XsdNonNegativeIntegerFeature() {
    super(OWL2Datatype.XSD_NON_NEGATIVE_INTEGER);
  }

}
