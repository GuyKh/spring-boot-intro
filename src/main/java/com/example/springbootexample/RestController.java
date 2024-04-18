package com.example.springbootexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  private WordCountService wordCountService;


  @RequestMapping(method = RequestMethod.GET, path = "/words/{word}")
  public ResponseEntity<String> getWord(@PathVariable("word") String word) {
    return ResponseEntity.ok("wordCount: " + wordCountService.getWordCount(word));
  }

  @RequestMapping(method = RequestMethod.GET, path = "/test")
  public ResponseEntity<String> getTest() {
    return ResponseEntity.ok("test hi Yarin, and Stephanie Te-st");
  }

  @RequestMapping(method = RequestMethod.POST, path = "/words/")
  public ResponseEntity<String> postExample(@RequestBody PostRequest request) {

    // Call word counter
    wordCountService.countWords(request.getUrl());

    // Return the response from my service
    return ResponseEntity.ok("Done");
  }
}
