package com.crudExample.util;

public class Resource {
    private Long id;
    private String name;
    private String description; // Additional field for demonstration
    private String type; // Additional field for demonstration

    // Default constructor
    public Resource() {
    }

    // Parameterized constructor
    public Resource(Long id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
