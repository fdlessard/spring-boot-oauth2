package io.fdlessard.codebites.oauth2.authorization;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {

  @EqualsAndHashCode.Exclude
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JsonIgnore
  @Version
  @Column(name = "version")
  private int version;

  @NotNull
  @Column(name = "username", unique = true, nullable = false, length = 255)
  private String username;

  @Column(name = "password", length = 60)
  private String password;

  @Column(name = "account_non_expired")
  private boolean accountNonExpired;

  @Column(name = "account_non_locked")
  private boolean accountNonLocked;

  @Column(name = "credentials_non_expired")
  private boolean credentialsNonExpired;

  @Column(name = "enabled")
  private boolean enabled;

  @OneToMany(
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER
  )
  @JoinColumn(name = "user_id")
  private Set<Authority> authorities;
}
