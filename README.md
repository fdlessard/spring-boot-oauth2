# In memory H2 database console
  
- http://localhost:8080/h2-console

# OAuth2 Authorization end point

## Obtain a token

  - POST http://localhost:8081/oauth/token
  
    ![postman-1](postman-1.png)
  
    ![postman-2](postman-2.png)
  
## Check a token

  - POST http://localhost:8081/oauth/check_token

    ![postman-3](postman-3.png)
  
    ![postman-4](postman-4.png)
  

### Database password BCrypt

- https://www.browserling.com/tools/bcrypt

### References

- https://pattern-match.com/blog/2018/10/17/springboot2-with-oauth2-integration/