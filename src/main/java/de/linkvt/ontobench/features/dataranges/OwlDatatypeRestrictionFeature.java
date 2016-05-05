package de.linkvt.ontobench.features.dataranges;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.springframework.stereotype.Component;

@Component
public class OwlDatatypeRestrictionFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = factory.getOWLDatatype(":DatatypeRestrictionDatatype", pm);

    OWLFacetRestriction fr1 = factory.getOWLFacetRestriction(OWLFacet.MIN_LENGTH, 10);
    OWLLiteral patternLiteral = factory.getOWLLiteral("DatatypeRestrictionLiteral");
    OWLFacetRestriction fr2 = factory.getOWLFacetRestriction(OWLFacet.PATTERN, patternLiteral);

    OWLDatatypeRestriction restriction = factory.getOWLDatatypeRestriction(datatype, fr1, fr2);

    OWLDataProperty property = factory.getOWLDataProperty(":datatypeRestrictionProperty", pm);
    addToGenericDomainAndNewRange(property, restriction);
  }

  @Override
  public String getName() {
    return "DatatypeRestriction";
  }

  @Override
  public String getToken() {
    return "restrictiondata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }
}
