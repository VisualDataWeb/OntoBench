package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdTokenFeature extends AbstractDatatypeMapFeature {

  public XsdTokenFeature() {
    super(OWL2Datatype.XSD_TOKEN);
  }

}
