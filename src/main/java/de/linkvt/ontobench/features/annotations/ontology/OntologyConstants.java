package de.linkvt.ontobench.features.annotations.ontology;

import org.semanticweb.owlapi.model.IRI;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class OntologyConstants {

  public static final IRI ONTOVIBE_CORE_IRI = IRI.create("http://ontovibe.visualdataweb.org/");
  public static final IRI ONTOVIBE_MINIMAL_IRI = IRI.create("http://ontovibe.visualdataweb.org/minimal/");

  public String getContributor() {
    return "Vincent Link";
  }

  public String getCreator() {
    return "Ontology Visualization Benchmark Generator";
  }

  public String getDescription() {
    return "Benchmark ontology created with the " + getCreator();
  }

  /**
   * @return the current date in W3C Date Format (http://www.w3.org/TR/NOTE-datetime)
   */
  public String getGenerationDate() {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }

  public String getTitle() {
    return "Benchmark Ontology";
  }

  public String getVersion() {
    return "1.0";
  }
}
