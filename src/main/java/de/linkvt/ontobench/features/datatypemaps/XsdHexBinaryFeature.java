package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdHexBinaryFeature extends AbstractDatatypeMapFeature {

  public XsdHexBinaryFeature() {
    super(OWL2Datatype.XSD_HEX_BINARY);
  }

}
