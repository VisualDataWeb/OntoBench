package de.linkvt.ontobench.persistence;

import de.linkvt.ontobench.features.Feature;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "FEATURE",
    uniqueConstraints = @UniqueConstraint(name = "UNIQUE_TOKEN", columnNames = "TOKEN"))
public class StoredFeature {

  @Id
  @Column(name = "TOKEN")
  private String token;

  protected StoredFeature() {
  }

  public StoredFeature(Feature feature) {
    token = feature.getToken();
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    StoredFeature that = (StoredFeature) o;

    return new EqualsBuilder()
        .append(token, that.token)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(token)
        .toHashCode();
  }
}
