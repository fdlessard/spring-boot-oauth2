package io.fdlessard.codebites.oauth2.resource;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {

  @GetMapping(value = "/hello")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String hello() {

    log.info("HelloWorldController.hello()");
    return "Hello world - from ResourceApplication";
  }
}
