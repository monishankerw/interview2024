     


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


Here's a `.md` file detailing dependency injection annotations in Spring, along with code examples:

---

### **DependencyInjectionAnnotations.md**

```md
# Spring Dependency Injection Annotations with Code Examples

## @Autowired
The `@Autowired` annotation is used to automatically inject dependencies by Spring's Dependency Injection mechanism.

### Example:

```java
@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    public List<Item> getItems() {
        return myRepository.findAll();
    }
}
```

In this example, `MyRepository` is automatically injected into `MyService` by Spring.

---

## @Qualifier
`@Qualifier` is used to specify which bean to inject when multiple beans of the same type exist in the application context.

### Example:

```java
@Service
public class MyService {

    @Autowired
    @Qualifier("primaryRepository")
    private MyRepository myRepository;

    public List<Item> getItems() {
        return myRepository.findAll();
    }
}
```

Here, `@Qualifier("primaryRepository")` specifies the exact bean to inject when multiple beans of the same type are available.

---

## @Inject
The `@Inject` annotation is a Java alternative to `@Autowired` that is part of the `javax.inject` package.

### Example:

```java
@Service
public class MyService {

    @Inject
    private MyRepository myRepository;

    public List<Item> getItems() {
        return myRepository.findAll();
    }
}
```

This functions similarly to `@Autowired` but comes from the standard Java `javax.inject` package.

---

## @Resource
`@Resource` is a JSR-250 annotation that behaves similarly to `@Autowired` but allows more control over the injection by name or type.

### Example:

```java
@Service
public class MyService {

    @Resource(name = "mySpecificRepository")
    private MyRepository myRepository;

    public List<Item> getItems() {
        return myRepository.findAll();
    }
}
```

`@Resource` allows you to inject a bean by its name or type. In this case, it injects a bean with the name `"mySpecificRepository"`.

---

## @Component
The `@Component` annotation marks a class as a Spring-managed component. It is a generic stereotype for any Spring-managed bean.

### Example:

```java
@Component
public class MyComponent {

    public void doSomething() {
        System.out.println("Component doing something!");
    }
}
```

The `MyComponent` class is now a Spring-managed bean and can be injected where needed.

---

## @Service
`@Service` is a specialization of `@Component` that indicates a service-layer class.

### Example:

```java
@Service
public class UserService {

    public User getUserById(Long id) {
        // Fetch user from the database
    }
}
```

`@Service` is used to mark the service layer, which usually contains business logic.

---

## @Repository
`@Repository` is a specialization of `@Component` that indicates a data access object (DAO) class.

### Example:

```java
@Repository
public class UserRepository {

    public User findById(Long id) {
        // Database logic to find user by ID
    }
}
```

`@Repository` marks the DAO layer responsible for interacting with the database.

---

## @Scope
`@Scope` is used to define the scope of a Spring bean. The most common scopes are `singleton` and `prototype`.

### Example:

```java
@Component
@Scope("prototype")
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("New PrototypeBean instance created!");
    }
}
```

Here, a new instance of `PrototypeBean` will be created every time it is requested from the Spring container.

---

This `.md` file provides clear explanations and code examples for the key dependency injection annotations in Spring.
```

---

Here is a `.md` file with detailed explanations and code examples for `@Value`, `@Cacheable`, and `@Async` annotations in Spring:

---

### **Value_Cacheable_Async_Annotations.md**

```md
# Spring Annotations: @Value, @Cacheable, and @Async

## 1. @Value
The `@Value` annotation is used to inject values into fields from properties or environment variables. It is commonly used in Spring to inject configuration properties.

### Example:

```java
@Service
public class MyService {

    @Value("${my.custom.property}")
    private String customProperty;

    public String getCustomProperty() {
        return customProperty;
    }
}
```

In this example, `@Value("${my.custom.property}")` injects the value of `my.custom.property` from `application.properties` into the `customProperty` field.

### application.properties:

```
my.custom.property=Hello, World!
```

Output when calling `getCustomProperty()` will be `"Hello, World!"`.

---

## 2. @Cacheable
The `@Cacheable` annotation is used to mark methods whose results should be cached. When a method annotated with `@Cacheable` is invoked, Spring checks whether the result is already in the cache. If it is, the cached value is returned; if not, the method is executed and the result is cached.

### Example:

```java
@Service
public class UserService {

    @Cacheable("users")
    public User findUserById(Long id) {
        // Simulate a slow database query
        simulateSlowService();
        return new User(id, "John Doe");
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000L); // 3 seconds delay
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
```

In this example, the `findUserById` method is annotated with `@Cacheable("users")`. When the method is called with a specific `id`, the result is stored in the cache with the key `"users"`. On subsequent calls with the same `id`, the cached value will be returned, avoiding the delay caused by `simulateSlowService()`.

### Configuration in `application.properties`:

```properties
spring.cache.type=simple
```

This enables a simple in-memory cache.

---

## 3. @Async
The `@Async` annotation is used to run methods asynchronously in the background. When a method is annotated with `@Async`, Spring executes it in a separate thread, so the caller does not have to wait for the method to complete.

### Example:

```java
@Service
public class NotificationService {

    @Async
    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
        simulateLongRunningTask();
        System.out.println("Notification sent!");
    }

    private void simulateLongRunningTask() {
        try {
            Thread.sleep(5000L); // 5 seconds delay
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
```

In this example, the `sendNotification` method runs asynchronously in the background. The calling method will not have to wait for the 5-second delay caused by `simulateLongRunningTask()`.

### Example of calling the method:

```java
@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/send")
    public String sendNotification() {
        notificationService.sendNotification("Hello, Async World!");
        return "Notification request received!";
    }
}
```

When calling `/send`, the response `"Notification request received!"` will be returned immediately while the `sendNotification` method executes in the background.

### Configuration in `application.properties`:

```properties
spring.task.execution.pool.core-size=5
spring.task.execution.pool.max-size=10
spring.task.execution.pool.queue-capacity=500
```

This configures the thread pool for executing async tasks.

### Enable Async Support:
Make sure to enable asynchronous processing in your Spring Boot application by adding the `@EnableAsync` annotation to your main class.

```java
@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

---

This `.md` file explains the use of `@Value`, `@Cacheable`, and `@Async` annotations in Spring with code examples.
```

---

This `.md` file provides detailed explanations and practical examples for the annotations you've requested. Let me know if you'd like any further details or other annotations!
This `.md` file provides a complete overview of commonly used Spring Boot and Spring MVC annotations with descriptions and usage examples.