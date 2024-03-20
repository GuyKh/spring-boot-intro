package com.example.springbootexample;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PingIntegrationTest {
  private final Gson gson = new Gson();

  @Autowired
  private MockMvc mvc;

  @Test
  public void testGetEndpoint() throws Exception {
    String response = mvc
        .perform(get("/api/get"))
        .andReturn().getResponse().getContentAsString();
    assertEquals("alive", response);
  }

  @Test
  public void testPostEndpoint() throws Exception {
    PostRequest request = new PostRequest();
    request.setData("ExampleData");

    String jsonResponse = mvc
            .perform(post("/api/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(request)))
            .andReturn().getResponse().getContentAsString();

    PostResponse response = gson.fromJson(jsonResponse, PostResponse.class);

    PostResponse expectedResponse = new PostResponse();
    expectedResponse.setMessage("Received POST request with data: " + request.getData());
    assertEquals(expectedResponse, response);
  }
}