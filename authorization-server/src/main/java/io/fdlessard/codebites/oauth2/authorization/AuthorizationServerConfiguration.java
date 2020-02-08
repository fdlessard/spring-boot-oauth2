package io.fdlessard.codebites.oauth2.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

<<<<<<< HEAD
    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
        authorizationServerSecurityConfigurer.checkTokenAccess("permitAll()")
                .tokenKeyAccess("permitAll()");
//                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer
                .inMemory()
                .withClient(oAuth2ClientProperties.getClientId())
                .secret(oAuth2ClientProperties.getClientSecret())
                .authorizedGrantTypes(oAuth2ClientProperties.getAuthorizedGrantTypes())
                .scopes(oAuth2ClientProperties.getScopes())
                .accessTokenValiditySeconds(oAuth2ClientProperties.getAccessTokenValiditySeconds())
                .refreshTokenValiditySeconds(oAuth2ClientProperties.getAccessTokenValiditySeconds());
    }
=======
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

 @Override
 public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
   oauthServer.checkTokenAccess("permitAll()");
 }

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
>>>>>>> 0311251bcef66235737ff0ce758d9febc9a01bf6
}
