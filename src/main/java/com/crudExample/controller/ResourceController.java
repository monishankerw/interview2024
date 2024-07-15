package com.crudExample.controller;

import com.crudExample.exception.ResourceNotFoundException;
import com.crudExample.service.ResourceService;
import com.crudExample.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
@Autowired
private ResourceService resourceService;
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Resource resource = (Resource) resourceService.getResourceById(id); // Assume this method retrieves the resource or returns null.
        if (resource == null) {
            throw new ResourceNotFoundException("Resource not found with id: " + id);
        }
        return ResponseEntity.ok(resource);
    }
    @PostMapping("/save")
    public Resource add(Resource resource){
        Resource resource1=resourceService.saveResources(resource);
        if(resource1==null){

            throw new ResourceNotFoundException("Resource not save:"+resource);
        }
        return resource1;
    }


}