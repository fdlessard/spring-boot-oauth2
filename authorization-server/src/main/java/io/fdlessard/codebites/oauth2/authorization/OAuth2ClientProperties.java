package io.fdlessard.codebites.oauth2.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "security.oauth2.client")
public class OAuth2ClientProperties {

  private String clientId;
  private String clientSecret;
  private String[] scopes;
  private String[] authorizedGrantTypes;
  private int accessTokenValiditySeconds;
  private int refreshTokenValiditySeconds;

}
