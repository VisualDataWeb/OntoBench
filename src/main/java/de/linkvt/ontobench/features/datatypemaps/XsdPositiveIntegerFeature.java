package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdPositiveIntegerFeature extends AbstractDatatypeMapFeature {

  public XsdPositiveIntegerFeature() {
    super(OWL2Datatype.XSD_POSITIVE_INTEGER);
  }

}
