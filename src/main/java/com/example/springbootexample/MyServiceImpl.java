package com.example.springbootexample;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public PostResponse createPostResponse(PostRequest request) {
        // Handle the POST request body here
        System.out.println("Received POST request with body: " + request);

        // You can perform any business logic or processing here

        // Create a response
        PostResponse response = new PostResponse();
        response.setMessage("Received POST request with data: " + request.getData());
        return response;
    }
}
