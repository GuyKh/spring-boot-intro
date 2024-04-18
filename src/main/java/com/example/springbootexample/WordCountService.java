package com.example.springbootexample;

public interface WordCountService {
    void countWords(String url);

    long getWordCount(String word);
}
