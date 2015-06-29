package de.linkvt.bachelor.web;

import de.linkvt.bachelor.generator.OntologyGenerator;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

  @RequestMapping(value = "/ontology")
  public OWLOntology ontology() throws OWLOntologyCreationException {
    return ontology(null);
  }

  @RequestMapping(value = "/ontology/{id}")
  public OWLOntology ontology(@PathVariable String id) throws OWLOntologyCreationException {
    return new OntologyGenerator().generate();
  }

}
