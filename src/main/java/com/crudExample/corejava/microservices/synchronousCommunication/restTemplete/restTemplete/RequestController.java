//package com.crudExample.corejava.microservices.md.synchronousCommunication.restTemplete.restTemplete;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/rest")
//@RequiredArgsConstructor
//public class RequestController {
//
//    private final RequestService requestService;
//
//    @PostMapping("/save")
//    public ResponseEntity<RequestDto> createTemp(@RequestBody RequestDto requestDto) {
//        return requestService.requestSave(
//        requestDto);
//    }
//}
//
