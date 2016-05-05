package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdStringFeature extends AbstractDatatypeMapFeature {

  public XsdStringFeature() {
    super(OWL2Datatype.XSD_STRING);
  }

}
