//package com.crudExample.corejava.microservices.md.synchronousCommunication.restTemplete.restTemplete;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//@RequiredArgsConstructor
//@Service
//public class RequestService {
//
//    private final RestTemplate restTemplate;
//    @Value("${api.base.url}")
//
//    private String baseUrl;
//
//    public ResponseEntity<RequestDto> requestSave(RequestDto requestDto) {
//        ResponseEntity<RequestDto> response = restTemplate.postForEntity(baseUrl, requestDto, RequestDto.class);
//        return response;
//    }
//}
