package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdIntegerFeature extends AbstractDatatypeMapFeature {

  public XsdIntegerFeature() {
    super(OWL2Datatype.XSD_INTEGER);
  }

}
