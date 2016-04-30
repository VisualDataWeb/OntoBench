package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdNameFeature extends AbstractDatatypeMapFeature {

  public XsdNameFeature() {
    super(OWL2Datatype.XSD_NAME);
  }

}
