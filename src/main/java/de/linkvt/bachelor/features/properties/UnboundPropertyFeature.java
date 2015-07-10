package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Property without domain and range.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class UnboundPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLProperty property = featurePool.getExclusiveProperty("HasNoDomainAndRange");
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(property);

    addAxiomToOntology(axiom);
  }
}
