package com.crudExample.corejava.microservices.synchronousCommunication.restTemplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class MyController {

    @Autowired
    private MyService myService;

    // GET endpoint
    @GetMapping("/fetch")
    public String fetchData() {
        return myService.getSomething();
    }

    // POST endpoint
    @PostMapping("/create")
    public String createData(@RequestBody Object requestBody) {
        return myService.createSomething(requestBody);
    }

    // PUT endpoint
    @PutMapping("/update/{id}")
    public void updateData(@PathVariable int id, @RequestBody Object requestBody) {
        myService.updateSomething(id, requestBody);
    }

    // DELETE endpoint
    @DeleteMapping("/delete/{id}")
    public void deleteData(@PathVariable int id) {
        myService.deleteSomething(id);
    }
}
