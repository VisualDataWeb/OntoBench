package de.linkvt.bachelor.persistence;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Combines parameters with a unique id.
 */
@Entity
public class StoredGeneration {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stored_generation_seq_gen")
  @GenericGenerator(name = "stored_generation_seq_gen", strategy = "sequence")
  private Long id;

  @ManyToMany(cascade = CascadeType.ALL)
  private List<StoredFeature> parameters;

  protected StoredGeneration() {
  }

  public StoredGeneration(List<StoredFeature> parameters) {
    this.parameters = parameters;
  }

  public List<StoredFeature> getParameters() {
    return parameters;
  }

  public void setParameters(List<StoredFeature> parameters) {
    this.parameters = parameters;
  }

  public Long getId() {
    return id;
  }

}
