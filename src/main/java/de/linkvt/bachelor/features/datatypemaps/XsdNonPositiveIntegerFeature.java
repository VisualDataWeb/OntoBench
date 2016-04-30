package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdNonPositiveIntegerFeature extends AbstractDatatypeMapFeature {

  public XsdNonPositiveIntegerFeature() {
    super(OWL2Datatype.XSD_NON_POSITIVE_INTEGER);
  }

}
