package de.linkvt.bachelor.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Combines parameters with a unique id.
 */
@Entity
public class StoredGeneration {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> parameters;

  protected StoredGeneration() {
  }

  public StoredGeneration(List<String> parameters) {
    this.parameters = parameters;
  }

  public List<String> getParameters() {
    return parameters;
  }

  public void setParameters(List<String> parameters) {
    this.parameters = parameters;
  }

  public Long getId() {
    return id;
  }

}
