
### 1. **API Gateway Pattern**
This pattern involves having a gateway service that routes client requests to the appropriate microservice.

**Example using Spring Cloud Gateway:**
```java
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r.path("/order/**")
                        .uri("lb://ORDER-SERVICE"))
                .route("payment-service", r -> r.path("/payment/**")
                        .uri("lb://PAYMENT-SERVICE"))
                .build();
    }
}
```
- The gateway service will route `/order/**` to `ORDER-SERVICE` and `/payment/**` to `PAYMENT-SERVICE`.

### 2. **Circuit Breaker Pattern**
The Circuit Breaker prevents a failing service from overwhelming other services or causing cascading failures.

**Example using Resilience4j:**
```java
@CircuitBreaker(name = "orderService", fallbackMethod = "orderFallback")
public String placeOrder(OrderRequest request) {
    // Call to Order Service
}

public String orderFallback(OrderRequest request, Throwable t) {
    return "Order service is currently unavailable. Please try again later.";
}
```
- If `placeOrder()` fails, the fallback method `orderFallback()` is invoked.

### 3. **Saga Pattern**
The Saga pattern manages distributed transactions across microservices. This can be implemented using events or orchestrators. Here's an example of a simple event-driven Saga.

**Example using an event-driven approach with Kafka:**
```java
// Order Service publishes an event when an order is created
public class OrderService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void createOrder(Order order) {
        // Save order
        kafkaTemplate.send("order-topic", order.getId().toString());
    }
}
```

```java
// Payment Service listens to the order topic and processes payment
@KafkaListener(topics = "order-topic")
public void processPayment(String orderId) {
    // Process payment for the order
}
```

### 4. **Event-Driven Architecture**
In an event-driven system, services communicate asynchronously via events, which helps decouple services.

**Example using RabbitMQ for Event-Driven Communication:**
```java
// Publisher: Product Service sending an event when a product is added
@Autowired
private RabbitTemplate rabbitTemplate;

public void addProduct(Product product) {
    productRepository.save(product);
    rabbitTemplate.convertAndSend("productExchange", "product.added", product);
}
```

```java
// Consumer: Inventory Service updating stock when a product is added
@RabbitListener(queues = "productQueue")
public void updateInventory(Product product) {
    // Update inventory
}
```

### 5. **Database per Service Pattern**
Each service should have its own database to ensure loose coupling. Here’s an example of two services with their own databases.

**Order Service Configuration (application.yml):**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/order_db
    username: root
    password: root
```

**Payment Service Configuration (application.yml):**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/payment_db
    username: root
    password: root
```
Each microservice connects to its own isolated database.

### 6. **Best Practices**

#### a. **Use Containerization (Docker Example):**
A Dockerfile for a Spring Boot microservice might look like this:
```Dockerfile
FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/my-microservice.jar my-microservice.jar
ENTRYPOINT ["java","-jar","/my-microservice.jar"]
```

#### b. **CI/CD with Jenkins Pipeline (Declarative Pipeline Example):**
```groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
            }
        }
    }
}
```

#### c. **Centralized Logging with ELK Stack (Logstash Configuration Example):**
```bash
input {
  beats {
    port => 5044
  }
}

output {
  elasticsearch {
    hosts => ["localhost:9200"]
    index => "microservices-logs-%{+YYYY.MM.dd}"
  }
}
```
This setup collects logs from microservices and sends them to Elasticsearch.

### 7. **Use Case Example: E-Commerce Application**
Imagine a system where different microservices handle user management, product catalog, order management, and payment processing.

#### Example: Order Service REST Endpoint
```java
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
```

#### Example: Payment Service REST Endpoint
```java
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        String result = paymentService.processPayment(paymentRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
```

In this scenario, both services operate independently and communicate via APIs or messaging systems like Kafka, RabbitMQ, etc.

These examples demonstrate the implementation of microservices patterns and practices, helping you build resilient, scalable, and decoupled systems.