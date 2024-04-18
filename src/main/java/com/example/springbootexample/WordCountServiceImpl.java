package com.example.springbootexample;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordCountServiceImpl implements WordCountService {
    private Map<String, Long> wordCount;
    private final int bufferSize;

    public WordCountServiceImpl() {
        this.wordCount = new HashMap<>();
        this.bufferSize = 5;
    }

    @Override
    public void countWords(String inputUrl) {
        char[] buffer = new char[bufferSize];

        try {
            URL url = new URL(inputUrl); // creating a url object
            URLConnection urlConnection = url.openConnection(); // creating a urlconnection object

            // wrapping the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the urlconnection using the bufferedreader
            StringBuilder stringBuilder = new StringBuilder();
            int readChars;
            while ((readChars = bufferedReader.read(buffer)) != -1) {

                /*  How are we today, what a lovely day
                    [H,o,w, ,a]
                    [r,e, ,w, e]

                    String s = "How a"; <---
                    String s2 = "How are we"
                 */

                for (int i = 0; i<readChars; i++) {
                    char c = buffer[i];
                    if (c == ' ' || c == '\n' || c == '-' || c == ',') {
                        String word = stringBuilder.toString().toLowerCase();
                        if (word.isEmpty()) continue;
                        System.out.println("Next word: " + word);
                        wordCount.put(word, wordCount.getOrDefault(word, 0L) + 1L );
                        stringBuilder = new StringBuilder();
                    } else {
                        stringBuilder.append(c);
                    }
                }
            }

            if (!stringBuilder.toString().isEmpty()) {
                String word = stringBuilder.toString();
                wordCount.put(word, wordCount.getOrDefault(word, 0L) + 1L );
            }

            bufferedReader.close();
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public long getWordCount(String word) {
        return wordCount.computeIfAbsent(word.toLowerCase(), k -> 0L);
    }
}
