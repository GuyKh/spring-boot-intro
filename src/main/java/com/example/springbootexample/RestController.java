package com.example.springbootexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  private MyService myService;


  @RequestMapping(method = RequestMethod.GET, path = "/api/get")
  public ResponseEntity<String> getExample() {
    return ResponseEntity.ok("alive");
  }

  @RequestMapping(method = RequestMethod.POST, path = "/api/post")
  public PostResponse postExample(@RequestBody PostRequest request) {

    // Return the response from my service
    return myService.createPostResponse(request);
  }
}
