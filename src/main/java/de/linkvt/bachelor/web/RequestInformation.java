package de.linkvt.bachelor.web;

import de.linkvt.bachelor.config.OntologyIriExtractor;
import de.linkvt.bachelor.generator.OntologyGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;


@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestInformation {

  private HttpServletRequest request;
  private Long generationId;
  private OntologyGenerator generator;

  private OntologyIriExtractor ontologyIriExtractor;

  @Autowired
  public RequestInformation(HttpServletRequest request, OntologyGenerator generator, OntologyIriExtractor ontologyIriExtractor) {
    this.request = request;
    this.generator = generator;
    this.ontologyIriExtractor = ontologyIriExtractor;
  }

  public Long getGenerationId() {
    return generationId;
  }

  public void setGenerationId(Long id) {
    this.generationId = id;
  }

  public OntologyGenerator getGenerator() {
    return generator;
  }

  public String getOntologyIri() {
    return ontologyIriExtractor.extractOntologyIri(request.getRequestURL().toString(), generationId);
  }
}
