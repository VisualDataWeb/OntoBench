package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdBooleanFeature extends AbstractDatatypeMapFeature {

  public XsdBooleanFeature() {
    super(OWL2Datatype.XSD_BOOLEAN);
  }

}
