     


      Here is a comprehensive list of Spring Boot and Spring MVC annotations, explained in Markdown format:

```markdown
# Spring Boot and Spring MVC Annotations

## Spring Boot Annotations

### 1. `@SpringBootApplication`
- **Description**: Indicates a configuration class that declares one or more `@Bean` methods and also triggers auto-configuration and component scanning.
- **Usage**: Placed on the main application class.

```java
@SpringBootApplication
public class MyApplication { }
```

---

### 2. `@EnableAutoConfiguration`
- **Description**: Enables Spring Boot's auto-configuration mechanism, which automatically configures your application based on the dependencies you have added.
- **Usage**: Automatically included in `@SpringBootApplication`.

---

### 3. `@ComponentScan`
- **Description**: Configures component scanning, allowing Spring to automatically detect and register beans from packages.
- **Usage**: Automatically included in `@SpringBootApplication`.

```java
@ComponentScan(basePackages = "com.example")
```

---

### 4. `@Configuration`
- **Description**: Marks a class as a source of bean definitions for the application context.
- **Usage**: Can be used to define custom beans.

```java
@Configuration
public class MyConfig {
    @Bean
    public MyBean myBean() { return new MyBean(); }
}
```

---

### 5. `@Bean`
- **Description**: Indicates that a method produces a bean to be managed by the Spring container.
- **Usage**: Usually used within a `@Configuration` class.

```java
@Bean
public MyService myService() {
    return new MyService();
}
```

---

## Spring MVC Annotations

### 1. `@Controller`
- **Description**: Marks a class as a Spring MVC controller, capable of handling HTTP requests and returning a view.
- **Usage**: Used for creating web controllers that return views.

```java
@Controller
public class MyController { }
```

---

### 2. `@RestController`
- **Description**: Combines `@Controller` and `@ResponseBody`. It is used to create RESTful web services where the return value of controller methods is written directly to the HTTP response body.
- **Usage**: Used for RESTful controllers that return data in JSON or XML format.

```java
@RestController
public class MyRestController { }
```

---

### 3. `@RequestMapping`
- **Description**: Maps HTTP requests to handler methods of MVC and REST controllers.
- **Usage**: Can be used at the class level and method level to define the URL mappings.

```java
@RequestMapping("/path")
public class MyController { }
```

---

### 4. `@GetMapping`
- **Description**: Shortcut for `@RequestMapping(method = RequestMethod.GET)`. It is used to map GET requests to specific handler methods.
- **Usage**: Used for handling GET requests.

```java
@GetMapping("/get")
public String handleGet() { return "response"; }
```

---

### 5. `@PostMapping`
- **Description**: Shortcut for `@RequestMapping(method = RequestMethod.POST)`. It is used to map POST requests to specific handler methods.
- **Usage**: Used for handling POST requests.

```java
@PostMapping("/post")
public String handlePost() { return "response"; }
```

---

### 6. `@PutMapping`
- **Description**: Shortcut for `@RequestMapping(method = RequestMethod.PUT)`. It is used to map PUT requests to specific handler methods.
- **Usage**: Used for handling PUT requests.

```java
@PutMapping("/put")
public String handlePut() { return "response"; }
```

---

### 7. `@DeleteMapping`
- **Description**: Shortcut for `@RequestMapping(method = RequestMethod.DELETE)`. It is used to map DELETE requests to specific handler methods.
- **Usage**: Used for handling DELETE requests.

```java
@DeleteMapping("/delete")
public void handleDelete() { }
```

---

### 8. `@PathVariable`
- **Description**: Used to bind a URI template variable to a method parameter in the controller.
- **Usage**: Used for extracting values from the URI.

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable("id") Long userId) { }
```

---

### 9. `@RequestParam`
- **Description**: Used to bind query parameters or form data from the request to method parameters.
- **Usage**: Extracts request parameters from the URL or form data.

```java
@GetMapping("/search")
public String search(@RequestParam("q") String query) { }
```

---

### 10. `@RequestBody`
- **Description**: Binds the body of the HTTP request to a method parameter. Typically used with `POST` and `PUT` requests.
- **Usage**: Used to deserialize JSON or XML data from the request body.

```java
@PostMapping("/create")
public User createUser(@RequestBody User user) { }
```

---

### 11. `@ResponseBody`
- **Description**: Binds the return value of the controller method to the HTTP response body. Automatically serializes the object to JSON or XML.
- **Usage**: Used in methods that return data instead of views.

```java
@GetMapping("/json")
@ResponseBody
public User getUser() { return new User("John"); }
```

---

### 12. `@ModelAttribute`
- **Description**: Binds method parameters or method return values to a model, which can be accessed in the view.
- **Usage**: Used in Spring MVC controllers to bind form data.

```java
@ModelAttribute
public void addAttributes(Model model) {
    model.addAttribute("attributeName", "attributeValue");
}
```

---

### 13. `@ExceptionHandler`
- **Description**: Used to handle exceptions thrown by request handler methods within the same controller.
- **Usage**: Customizes the exception handling mechanism.

```java
@ExceptionHandler(MyException.class)
public String handleException(MyException ex) {
    return "error";
}
```

---

### 14. `@ControllerAdvice`
- **Description**: Used to define global exception handling, model binding, or other global aspects for multiple controllers.
- **Usage**: Centralizes exception handling across all controllers.

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }
}
```

---

### 15. `@Valid`
- **Description**: Used for validating request body or parameters in controllers based on annotations like `@NotNull`, `@Size`, etc., defined in the model class.
- **Usage**: Triggers validation of an object.

```java
@PostMapping("/submit")
public String submit(@Valid @ModelAttribute("greeting") Greeting greeting, BindingResult result) {
    if (result.hasErrors()) {
        return "error";
    }
    return "success";
}
```

---

### 16. `@Slf4j`
- **Description**: Injects a logger instance using `SLF4J` for logging within the class.
- **Usage**: Used for logging in controllers and services.

```java
@Slf4j
@Controller
public class MyController { }
```

---

### 17. `@RequestHeader`
- **Description**: Used to bind a request header to a method parameter.
- **Usage**: Extracts specific HTTP headers from the request.

```java
@GetMapping("/header")
public String handleHeader(@RequestHeader("User-Agent") String userAgent) { }
```

---

### 18. `@CrossOrigin`
- **Description**: Enables Cross-Origin Resource Sharing (CORS) for a controller or method.
- **Usage**: Allows requests from different origins.

```java
@CrossOrigin(origins = "http://example.com")
@RestController
public class MyRestController { }
```

---

### 19. `@SessionAttributes`
- **Description**: Specifies which model attributes should be stored in the session.
- **Usage**: Used to store and retrieve data across multiple requests.

```java
@SessionAttributes("greeting")
@Controller
public class MyController { }
```
```

This `.md` file provides a complete overview of commonly used Spring Boot and Spring MVC annotations with descriptions and usage examples.