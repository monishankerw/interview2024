
    There are two styles of Microservices Communications:

    Synchronous Communication
    Asynchronous Communication


    Synchronous Communication

    In the case of Synchronous Communication,
    the client sends a request and waits for a response from the service.
    The important point here is that the protocol (HTTP/HTTPS) is synchronous and
    the client code can only continue its task when it receives the HTTP server response.

    For example,
    Microservice1 acts as a client that sends a request and waits for a response from Microservice2.

    We can use RestTemplate or WebClient or Spring Cloud Open Feign library to make a Synchronous Communication multiple microservices.



    Asynchronous Communication
    In the case of Asynchronous Communication, The client sends a request and does not wait for a response from the service. The client will continue executing its task - It doesn’t wait for the response from the service.

    For example, Microservice1 acts as a client that sends a request and doesn't wait for a response from Microservice2.


    We can use Message brokers such as RabbitMQ and Apache Kafka to make Asynchronous Communication between multiple microservices.
    What we will Build?
    Well, we will create two microservices such as department-service and user-service and we will make a REST API call from user-service to department-service to fetch a particular user department.
    Spring Boot Microservices Communication Example using RestTemplate

    We will create a separate MySQL database for each microservice.

    We will create and set up two Spring boot projects as two microservices in IntelliJ IDEA.


    UserService - Configure RestTemplate as Spring Bean
  @SpringBootApplication
  public class UserServiceApplication {

      public static void main(String[] args) {
          SpringApplication.run(UserServiceApplication.class, args);
      }

      @Bean
      public RestTemplate restTemplate(){
          return new RestTemplate();
      }
  }

    @Override
        public ResponseDto getUser(Long userId) {

            ResponseDto responseDto = new ResponseDto();
            User user = userRepository.findById(userId).get();
            UserDto userDto = mapToUser(user);

            ResponseEntity<DepartmentDto> responseEntity = restTemplate
                    .getForEntity("http://localhost:8080/api/departments/" + user.getDepartmentId(),
                    DepartmentDto.class);

            DepartmentDto departmentDto = responseEntity.getBody();

            System.out.println(responseEntity.getStatusCode());

            responseDto.setUser(userDto);
            responseDto.setDepartment(departmentDto);

            return responseDto;
        }




           how to use WebClient to make REST API calls (Synchronous communication) between multiple microservices.


           WebClient is a non-blocking, reactive client to perform HTTP requests, exposing a fluent, reactive API over underlying HTTP client libraries such as Reactor Netty.

           To use WebClient in our Spring boot project, we have to add Spring WebFlux dependency to the classpath.

           Step 1: Add Spring WebFlux Dependency
           Open the pom.xml file of the user-service project and add the below dependency:

           		<dependency>
           			<groupId>org.springframework.boot</groupId>
           			<artifactId>spring-boot-starter-webflux</artifactId>
           		</dependency>
           Step 2: Configure WebClient as Spring Bean
           package net.javaguides.userservice;

           import org.springframework.boot.SpringApplication;
           import org.springframework.boot.autoconfigure.SpringBootApplication;
           import org.springframework.context.annotation.Bean;
           import org.springframework.web.reactive.function.client.WebClient;

           @SpringBootApplication
           public class UserServiceApplication {

               public static void main(String[] args) {
                   SpringApplication.run(UserServiceApplication.class, args);
               }

               @Bean
               public WebClient webClient(){
                   return WebClient.builder().build();
               }
           }
           We have configured WebClient as Spring bean:
               @Bean
               public WebClient webClient(){
                   return WebClient.builder().build();
               }
           Step 3: Inject and Use WebClient to Call the REST API
           Let's inject WebClient and use it to make a REST API call:
                   DepartmentDto departmentDto = webClient.get()
                            .uri("http://localhost:8080/api/departments/" + user.getDepartmentId())
                                    .retrieve()
                                            .bodyToMono(DepartmentDto.class)
                                                    .block();
           Here is the complete code of the UserServiceImpl class for your reference:
           package net.javaguides.userservice.service.impl;

           import lombok.AllArgsConstructor;
           import net.javaguides.userservice.dto.DepartmentDto;
           import net.javaguides.userservice.dto.ResponseDto;
           import net.javaguides.userservice.dto.UserDto;
           import net.javaguides.userservice.entity.User;
           import net.javaguides.userservice.repository.UserRepository;
           import net.javaguides.userservice.service.UserService;
           import org.springframework.stereotype.Service;
           import org.springframework.web.reactive.function.client.WebClient;

           @Service
           @AllArgsConstructor
           public class UserServiceImpl implements UserService {

               private UserRepository userRepository;
               private RestTemplate restTemplate;
               private WebClient webClient;

               private APIClient apiClient;

               @Override
               public User saveUser(User user) {
                   return userRepository.save(user);
               }

               @Override
               public ResponseDto getUser(Long userId) {

                   ResponseDto responseDto = new ResponseDto();
                   User user = userRepository.findById(userId).get();
                   UserDto userDto = mapToUser(user);

                   DepartmentDto departmentDto = webClient.get()
                            .uri("http://localhost:8080/api/departments/" + user.getDepartmentId())
                                    .retrieve()
                                            .bodyToMono(DepartmentDto.class)
                                                    .block();
                   responseDto.setUser(userDto);
                   responseDto.setDepartment(departmentDto);

                   return responseDto;
               }

               private UserDto mapToUser(User user){
                   UserDto userDto = new UserDto();
                   userDto.setId(user.getId());
                   userDto.setFirstName(user.getFirstName());
                   userDto.setLastName(user.getLastName());
                   userDto.setEmail(user.getEmail());
                   return userDto;
               }
           }




              how to use the Spring Cloud Open Feign library
              to make REST API calls (Synchronous communication) between multiple microservices.


              Feign makes writing web service clients easier with pluggable annotation support, which includes Feign annotations and JAX-RS annotations. Also, Spring Cloud adds support for Spring MVC annotations and for using the same HttpMessageConverters as used in Spring Web.

              One great thing about using Feign is that we don't have to write any code for calling the service, other than an interface definition.

              For example:

              package net.javaguides.userservice.service;

              import net.javaguides.userservice.dto.DepartmentDto;
              import org.springframework.cloud.openfeign.FeignClient;
              import org.springframework.web.bind.annotation.GetMapping;
              import org.springframework.web.bind.annotation.PathVariable;

              @FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
              public interface APIClient {
                  @GetMapping(value = "/api/departments/{id}")
                  DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId);
              }



              Well, we will create two microservices such as department-service and user-service and we will make a REST API call using Spring Cloud Open Feign from user-service to department-service to fetch a particular user department.

              Step 1: Add Spring cloud open feign Maven dependency to User-Service

              Open the pom.xml file of the user-service project and add the below dependency:
              		<dependency>
              			<groupId>org.springframework.cloud</groupId>
              			<artifactId>spring-cloud-starter-openfeign</artifactId>
              		</dependency>



              		Here is the complete pom.xml file after adding Spring cloud open feign dependency:

                   <?xml version="1.0" encoding="UTF-8"?>
                   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
                   	<modelVersion>4.0.0</modelVersion>
                   	<parent>
                   		<groupId>org.springframework.boot</groupId>
                   		<artifactId>spring-boot-starter-parent</artifactId>
                   		<version>2.7.4</version>
                   		<relativePath/> <!-- lookup parent from repository -->
                   	</parent>
                   	<groupId>net.javaguides</groupId>
                   	<artifactId>user-service</artifactId>
                   	<version>0.0.1-SNAPSHOT</version>
                   	<name>user-service</name>
                   	<description>user-service</description>
                   	<properties>
                   		<java.version>17</java.version>
                   		<spring-cloud.version>2021.0.4</spring-cloud.version>
                   	</properties>
                   	<dependencies>
                   		<dependency>
                   			<groupId>org.springframework.boot</groupId>
                   			<artifactId>spring-boot-starter-data-jpa</artifactId>
                   		</dependency>
                   		<dependency>
                   			<groupId>org.springframework.boot</groupId>
                   			<artifactId>spring-boot-starter-web</artifactId>
                   		</dependency>
                   		<dependency>
                   			<groupId>org.springframework.cloud</groupId>
                   			<artifactId>spring-cloud-starter-openfeign</artifactId>
                   		</dependency>

                   		<dependency>
                   			<groupId>mysql</groupId>
                   			<artifactId>mysql-connector-java</artifactId>
                   			<scope>runtime</scope>
                   		</dependency>
                   		<dependency>
                   			<groupId>org.projectlombok</groupId>
                   			<artifactId>lombok</artifactId>
                   			<optional>true</optional>
                   		</dependency>
                   		<dependency>
                   			<groupId>org.springframework.boot</groupId>
                   			<artifactId>spring-boot-starter-test</artifactId>
                   			<scope>test</scope>
                   		</dependency>
                   	</dependencies>
                   	<dependencyManagement>
                   		<dependencies>
                   			<dependency>
                   				<groupId>org.springframework.cloud</groupId>
                   				<artifactId>spring-cloud-dependencies</artifactId>
                   				<version>${spring-cloud.version}</version>
                   				<type>pom</type>
                   				<scope>import</scope>
                   			</dependency>
                   		</dependencies>
                   	</dependencyManagement>

                   	<build>
                   		<plugins>
                   			<plugin>
                   				<groupId>org.springframework.boot</groupId>
                   				<artifactId>spring-boot-maven-plugin</artifactId>
                   				<configuration>
                   					<excludes>
                   						<exclude>
                   							<groupId>org.projectlombok</groupId>
                   							<artifactId>lombok</artifactId>
                   						</exclude>
                   					</excludes>
                   				</configuration>
                   			</plugin>
                   		</plugins>
                   	</build>

                   </project>
                   Step 2: Enable Feign Client using @EnableFeignClients
                   package net.javaguides.userservice;

                   import org.springframework.boot.SpringApplication;
                   import org.springframework.boot.autoconfigure.SpringBootApplication;
                   import org.springframework.cloud.openfeign.EnableFeignClients;

                   @SpringBootApplication
                   @EnableFeignClients
                   public class UserServiceApplication {

                       public static void main(String[] args) {
                           SpringApplication.run(UserServiceApplication.class, args);
                       }
                   }
                   Note that @EnableFeignClients annotation enables component scanning for interfaces that declare they are Feign clients.

                   Step 3: Create feign API client
                   After that, we need to have a feign API client with the necessary methods, requests, and responses.

                   Let's create an interface named APIClient and add the following code:

                   package net.javaguides.userservice.service;

                   import net.javaguides.userservice.dto.DepartmentDto;
                   import org.springframework.cloud.openfeign.FeignClient;
                   import org.springframework.web.bind.annotation.GetMapping;
                   import org.springframework.web.bind.annotation.PathVariable;

                   @FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
                   public interface APIClient {
                       @GetMapping(value = "/api/departments/{id}")
                       DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId);
                   }
                   We declare a Feign client using the @FeignClient annotation:

                   @FeignClient(value = "DEPARTMENT-SERVICE")
                   The value argument passed in the @FeignClient annotation is a mandatory, arbitrary client name, while with the URL argument, we specify the API base URL.

                   @FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
                   Furthermore, since this interface is a Feign client, we can use the Spring Web annotations to declare the APIs that we want to reach out to.

                   Step 4: Change the getUser method to call APIClient
                   First, inject APIClient and then use it:

                           DepartmentDto departmentDto = apiClient.getDepartmentById(user.getDepartmentId());
                   Here is the complete code of UserServiceImpl using Feign client for your reference:
                   package net.javaguides.userservice.service.impl;

                   import lombok.AllArgsConstructor;
                   import net.javaguides.userservice.dto.DepartmentDto;
                   import net.javaguides.userservice.dto.ResponseDto;
                   import net.javaguides.userservice.dto.UserDto;
                   import net.javaguides.userservice.entity.User;
                   import net.javaguides.userservice.repository.UserRepository;
                   import net.javaguides.userservice.service.APIClient;
                   import net.javaguides.userservice.service.UserService;
                   import org.springframework.stereotype.Service;

                   @Service
                   @AllArgsConstructor
                   public class UserServiceImpl implements UserService {

                       private UserRepository userRepository;

                       private APIClient apiClient;

                       @Override
                       public User saveUser(User user) {
                           return userRepository.save(user);
                       }

                       @Override
                       public ResponseDto getUser(Long userId) {

                           ResponseDto responseDto = new ResponseDto();
                           User user = userRepository.findById(userId).get();
                           UserDto userDto = mapToUser(user);

                           DepartmentDto departmentDto = apiClient.getDepartmentById(user.getDepartmentId());
                           responseDto.setUser(userDto);
                           responseDto.setDepartment(departmentDto);

                           return responseDto;
                       }

                       private UserDto mapToUser(User user){
                           UserDto userDto = new UserDto();
                           userDto.setId(user.getId());
                           userDto.setFirstName(user.getFirstName());
                           userDto.setLastName(user.getLastName());
                           userDto.setEmail(user.getEmail());
                           return userDto;
                       }
                   }