package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdLanguageFeature extends AbstractDatatypeMapFeature {

  public XsdLanguageFeature() {
    super(OWL2Datatype.XSD_LANGUAGE);
  }

}
