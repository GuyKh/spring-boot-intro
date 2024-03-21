package com.example.springbootexample;

public class PostRequest {
    private String data;

    // Getters and setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" + "data='" + data + '\'' + '}';
    }
}
