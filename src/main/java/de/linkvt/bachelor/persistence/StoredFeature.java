package de.linkvt.bachelor.persistence;

import de.linkvt.bachelor.features.Feature;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class StoredFeature {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stored_feature_seq_gen")
  @GenericGenerator(name = "stored_feature_seq_gen", strategy = "sequence")
  private Long id;

  @Column(name = "token")
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
