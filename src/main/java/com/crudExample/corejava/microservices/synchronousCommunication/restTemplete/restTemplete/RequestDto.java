package com.crudExample.corejava.microservices.synchronousCommunication.restTemplete.restTemplete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RequestDto {

    private String title;
    private String body;
    private String userId;

}
