package com.crudExample.corejava.microservices.synchronousCommunication.restTemplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    @Autowired
    private RestTemplate restTemplate;

    // Example of GET request
    public String getSomething() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    // Example of POST request
    public String createSomething(Object requestBody) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestBody, String.class);
        return response.getBody();
    }

    // Example of PUT request
    public void updateSomething(int id, Object requestBody) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        restTemplate.put(url, requestBody);
    }

    // Example of DELETE request
    public void deleteSomething(int id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        restTemplate.delete(url);
    }
}
