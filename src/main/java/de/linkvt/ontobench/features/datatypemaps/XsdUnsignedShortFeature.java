package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdUnsignedShortFeature extends AbstractDatatypeMapFeature {

  public XsdUnsignedShortFeature() {
    super(OWL2Datatype.XSD_UNSIGNED_SHORT);
  }

}
