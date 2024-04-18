package com.example.springbootexample;

public class PostRequest {
    private String url;

    // Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Request{" + "url='" + url + '\'' + '}';
    }
}
