package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdNMTokenFeature extends AbstractDatatypeMapFeature {

  public XsdNMTokenFeature() {
    super(OWL2Datatype.XSD_NMTOKEN);
  }

}
