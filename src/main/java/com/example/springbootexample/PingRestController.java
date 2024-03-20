package com.example.springbootexample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingRestController {

  @RequestMapping(method = RequestMethod.GET, path = "/api/get")
  public ResponseEntity<String> getExample() {
    return ResponseEntity.ok("alive");
  }

  @RequestMapping(method = RequestMethod.POST, path = "/api/post")
  public PostResponse postExample(@RequestBody PostRequest request) {
    // Handle the POST request body here
    System.out.println("Received POST request with body: " + request);

    // You can perform any business logic or processing here

    // Create a response
    PostResponse response = new PostResponse();
    response.setMessage("Received POST request with data: " + request.getData());

    // Return the response
    return response;
  }
}
