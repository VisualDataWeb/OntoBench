package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdFloatFeature extends AbstractDatatypeMapFeature {

  public XsdFloatFeature() {
    super(OWL2Datatype.XSD_FLOAT);
  }

}
