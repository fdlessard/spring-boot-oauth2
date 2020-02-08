package io.fdlessard.codebites.oauth2.authorization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {

  @EqualsAndHashCode.Exclude
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @JsonIgnore
  @Version
  @Column(name = "version")
  private int version;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "authority", length = 25)
  private String authority;
}
