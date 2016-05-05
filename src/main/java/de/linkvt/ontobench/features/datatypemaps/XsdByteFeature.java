package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdByteFeature extends AbstractDatatypeMapFeature {

  public XsdByteFeature() {
    super(OWL2Datatype.XSD_BYTE);
  }

}
