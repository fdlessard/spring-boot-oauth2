package io.fdlessard.codebites.oauth2.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private OAuth2ClientProperties oAuth2ClientProperties;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;


  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    endpoints.authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
  }

/*  @Override
  public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()")
        .passwordEncoder(passwordEncoder());
  }*/

  @Override
  public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
    configurer
        .inMemory()
        .withClient(oAuth2ClientProperties.getClientId())
        .secret(oAuth2ClientProperties.getClientSecret())
        .authorizedGrantTypes("authorization_code", "refresh_token", "password", "implicit", "client_credentials")
        .scopes("all")
        .accessTokenValiditySeconds(oAuth2ClientProperties.getAccessTokenValiditySeconds())
        .refreshTokenValiditySeconds(oAuth2ClientProperties.getAccessTokenValiditySeconds());
  }
}
