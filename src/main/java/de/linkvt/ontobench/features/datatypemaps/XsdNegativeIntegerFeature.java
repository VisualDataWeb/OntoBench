package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdNegativeIntegerFeature extends AbstractDatatypeMapFeature {

  public XsdNegativeIntegerFeature() {
    super(OWL2Datatype.XSD_NEGATIVE_INTEGER);
  }

}
