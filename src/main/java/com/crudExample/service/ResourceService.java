package com.crudExample.service;


import com.crudExample.util.Resource;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResourceService {
    private Map<Long, Resource> resources;
    private Long nextId; // To keep track of the next ID to assign

    public ResourceService() {
        resources = new HashMap<>();
        nextId = 3L; // Starting ID for new resources (assuming we have 2 initial resources)
        resources.put(1L, new Resource(1L, "Resource One", "Description One", "Type A"));
        resources.put(2L, new Resource(2L, "Resource Two", "Description Two", "Type B"));
    }

    public Resource getResourceById(Long id) {
        return resources.get(id);
    }

    public Resource addResource(Resource resource) {
        resource.setId(nextId++);
        resources.put(resource.getId(), resource);
        return resource;
    }

    public Resource saveResources(Resource resource) {
        resource.setId(Long.valueOf("122"));
        resource.setDescription("tew");
        resource.setName("tre");
        resource.setType("T4");
        System.out.println("test:::");
        return resource;
    }
}
