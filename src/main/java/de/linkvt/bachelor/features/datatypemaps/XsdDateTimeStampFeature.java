package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdDateTimeStampFeature extends AbstractDatatypeMapFeature {

  public XsdDateTimeStampFeature() {
    super(OWL2Datatype.XSD_DATE_TIME_STAMP);
  }

}
