package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdUnsignedIntFeature extends AbstractDatatypeMapFeature {

  public XsdUnsignedIntFeature() {
    super(OWL2Datatype.XSD_UNSIGNED_INT);
  }

}
