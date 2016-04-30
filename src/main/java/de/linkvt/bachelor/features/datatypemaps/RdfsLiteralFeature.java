package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class RdfsLiteralFeature extends AbstractDatatypeMapFeature {

  public RdfsLiteralFeature() {
    super(OWL2Datatype.RDFS_LITERAL);
  }

}
