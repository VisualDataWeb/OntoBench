package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdIntFeature extends AbstractDatatypeMapFeature {

  public XsdIntFeature() {
    super(OWL2Datatype.XSD_INT);
  }

}
