package de.linkvt.ontobench.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdDateTimeFeature extends AbstractDatatypeMapFeature {

  public XsdDateTimeFeature() {
    super(OWL2Datatype.XSD_DATE_TIME);
  }

}
