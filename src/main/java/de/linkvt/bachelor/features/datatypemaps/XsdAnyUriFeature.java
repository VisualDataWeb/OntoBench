package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdAnyUriFeature extends AbstractDatatypeMapFeature {

  public XsdAnyUriFeature() {
    super(OWL2Datatype.XSD_ANY_URI);
  }

}
