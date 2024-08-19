package com.crudExample.corejava.microservices;

/**
 * Simulating Microservices: UserService, OrderService, and PaymentService
 * Showing advantages (Fault Isolation, Scalability) and challenges (Data Consistency)
 */
public class MicroServiceArchitecture {
    public static void main(String[] args) {
        try {
            UserService userservice=new UserService();
            OrderService orderservice=new OrderService();
            PaymentService paymentService = new PaymentService();

            userservice.registerUser("Moni");
            orderservice.placeOrder("Moni","Laptop");
            paymentService.processPayment("Moni", 1200);
        }catch(Exception  e) {
            System.out.println("One of the service failed"+e.getMessage());
        }
    }

}

class UserService{

    public void registerUser(String username) {
        System.out.println("UserService: Registering user::::"+username);
    }

}

class OrderService{

    public void placeOrder(String username, String item) {
        System.out.println("OrderService: Placing order for " + username + " for item " + item);
        if(item.equals("laptop")) {
            throw new RuntimeException("OrderService: Inventory error for " + item);

        }
    }

}


class PaymentService {
    public void processPayment(String username, double amount) {
        System.out.println("PaymentService: Processing payment for " + username + " of amount $" + amount);
    }
}










