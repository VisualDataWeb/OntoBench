package de.linkvt.ontobench.persistence;

import de.linkvt.ontobench.features.Feature;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Combines parameters with a unique id.
 */
@Entity
@Table(name = "GENERATION")
public class StoredGeneration {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generation_seq_gen")
  @GenericGenerator(name = "generation_seq_gen", strategy = "sequence")
  private Long id;

  @ManyToMany
  @JoinTable(name = "GENERATION_FEATURE",
      joinColumns = @JoinColumn(name = "GENERATION_ID", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "FEATURE_TOKEN", referencedColumnName = "TOKEN"),
      uniqueConstraints = @UniqueConstraint(name = "UNIQUE_GENERATION", columnNames = {"GENERATION_ID", "FEATURE_TOKEN"}))
  private List<StoredFeature> parameters;

  protected StoredGeneration() {
  }

  public StoredGeneration(List<Feature> features) {
    this.parameters = features.stream()
        .map(Feature::getStoredFeature)
        .collect(Collectors.toList());
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StoredGeneration that = (StoredGeneration) o;
    return Objects.equals(id, that.id) && Objects.equals(parameters, that.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parameters);
  }
}
