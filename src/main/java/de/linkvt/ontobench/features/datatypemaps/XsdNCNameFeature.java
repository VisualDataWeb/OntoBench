package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdNCNameFeature extends AbstractDatatypeMapFeature {

  public XsdNCNameFeature() {
    super(OWL2Datatype.XSD_NCNAME);
  }

}
