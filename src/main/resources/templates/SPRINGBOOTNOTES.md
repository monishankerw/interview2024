

          1. What is Spring?
          ->Spring is dependency Injection framework to make java application loosely coupled.
          ->Spring framework makes the easy development of j2ee application.

          2. "loosely coupled" refers to a design approach
             where components or classes within a system have minimal dependencies on each other.
             This allows for greater flexibility, maintainability, and scalability of the application.

          3.  Dependency Injection-> It is core of spring framework ,
          it used to inject bean inside give the reference variable.

             Three types:
             a. Constructor Injection
             b. Setter Injection
             c. Field Injection

             a. Constructor Injection
             @Service
             public class MyService {
                 private final MyRepository myRepository;

                 @Autowired
                 public MyService(MyRepository myRepository) {  // Constructor Injection
                     this.myRepository = myRepository;
                 }

                 public void performService() {
                     myRepository.doSomething();
                 }
             }

             b. Setter Injection
             public class MyService {
                 private MyRepository myRepository;

                 public void setMyRepository(MyRepository myRepository) {  // Setter Injection
                     this.myRepository = myRepository;
                 }

                 public void performService() {
                     myRepository.doSomething();
                 }
             }

             c. Field Injection
             public class MyService {
             @Autowired
                 private MyRepository myRepository;



                 public void performService() {
                     myRepository.doSomething();
                 }
             }

     3. What is SpringBoot?
     Spring Boot is module of spring from which we speed up the development.
     SpringBoot on the top of the spring framework that eliminated boilerplate configurations required for spring applications.

     Features of Spring Boot.
     a. Faster way of developing applications by reducing the boilerplate configurations.
     b. Loosely coupled dependencies.
     c. Starter pack available as part of dependency for simplifying builds and configuration.
     d. Embedded container server support.By default Tomcat is used.
     e. Auto-configuration
     f. Externalized configuration with the help of .properties and .yml files and spring cloud config.

     4. Spring vs SpringBoot
     Spring:
     1. Performing Dependency injection complex because it was xml based.
     2. We xml file for configuration.
     3. Tomcat configuration needs to done separately.
     4. No spring stater tags.


     SpringBoot:
     1. It is easy.
     2. application.properties file for configuration.
     3. Embedded jasper tomcat which easy to configuration.
     4. Given spring stater tags.

     5. Spring initializer.
        Spring Initializer is a web-based tool provided by the Pivotal Web Service.
        With the help of Spring Initializer, we can easily generate the structure of the Spring Boot Project.
         It offers extensible API for creating JVM-based projects.

     6. Spring Core
        • Spring Core technologies are absolutely integral to the spring framework
        • The core technologies include
        • IoC : Inversion of Control or DI: Dependency Injection
        • Spring Beans
        • Spring Container
        • AOP: Aspect Oriented Programming

     6. What is spring IOC Container? types.
     -> Spring IOC container consists of implementation logic to perform dependency Injection.
     -> It also maintains Bean lifecycles.
     -> These are the design patterns that are used to remove dependency from the programming code. They make the code easier to test and maintain.
     -> IOC makes the code loosely coupled. In such case, there is no need to modify the code if our logic is moved to new environment.
     ->  In Spring framework, IOC container is responsible to inject the dependency. We provide metadata to the IOC container either by XML file
     There are Two types
     1. BeanFactory
     2. Spring Application context

BeanFactory vs ApplicationContext


1. Basic Definitions:
BeanFactory:
It is the simplest container that provides basic functionality for Dependency Injection (DI).
Location: Defined in the org.springframework.beans.factory.BeanFactory package.
Main Use: BeanFactory is primarily used for lightweight applications or resource-constrained environments where full Spring features are not required.
ApplicationContext:
It is a more advanced container that builds on top of BeanFactory, adding more enterprise-level functionalities such as AOP, internationalization, event propagation, etc.
Location: Defined in the org.springframework.context.ApplicationContext package.
Main Use: ApplicationContext is the more commonly used container for larger, full-fledged enterprise applications.
2. Initialization:
BeanFactory:
It uses lazy initialization. This means that bean instances are only created when they are first requested (i.e., when getBean() is called).
ApplicationContext:
It uses eager initialization for singleton beans. This means that beans are instantiated as soon as the ApplicationContext is started (unless explicitly configured for lazy initialization).
3. Dependency Injection and Configuration:
BeanFactory:
Supports basic dependency injection via XML configuration.
Does not support annotation-based dependency injection (e.g., @Autowired) by default.
ApplicationContext:
Supports advanced dependency injection and is fully compatible with annotation-based configuration (e.g., @Autowired, @Qualifier).
Also supports Java-based configuration and XML.
4. Bean Scopes:
BeanFactory:
Supports only two scopes: singleton and prototype.
ApplicationContext:
Supports all Spring bean scopes including singleton, prototype, request, session, and globalSession.
5. Support for Additional Services:
BeanFactory:
Basic container that does not provide built-in support for advanced services such as:
AOP (Aspect-Oriented Programming)
Transaction management
Message handling
ApplicationContext:
Advanced container that supports:
AOP for cross-cutting concerns.
Transaction management.
Event propagation and messaging.
Resource management (e.g., loading properties or files).
Internationalization (i18n).
6. Auto-Scanning for Components:
BeanFactory:
Does not support component auto-scanning. Bean definitions must be manually declared in the XML configuration.
ApplicationContext:
Supports component auto-scanning using annotations such as @ComponentScan. This automatically detects and registers beans annotated with @Component, @Service, @Repository, etc.
7. Event Handling:
BeanFactory:
Does not provide built-in support for event handling.
ApplicationContext:
Provides event handling capabilities, allowing beans to publish and listen for events within the application context (e.g., ApplicationEvent, ApplicationListener).
Key Differences Recap:
Feature	BeanFactory	ApplicationContext
Initialization	Lazy	Eager for singletons
Scopes Supported	Singleton, Prototype	All scopes (Singleton, Prototype, Request, Session, etc.)
Dependency Injection Support	XML-based, no annotation support	Full annotation and XML support
Auto-scanning Support	No	Yes
Advanced Features (AOP, Transactions, etc.)	No	Yes
Event Handling	No	Yes
Internationalization Support	No	Yes
Example Usage of Each:
BeanFactory Example:
java
Copy code
// XML configuration with BeanFactory
ClassPathResource resource = new ClassPathResource("beans.xml");
BeanFactory factory = new XmlBeanFactory(resource);
MyBean myBean = (MyBean) factory.getBean("myBean");
ApplicationContext Example:
java
Copy code
// Using ApplicationContext
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
MyBean myBean = context.getBean(MyBean.class);
Conclusion:
BeanFactory is useful in lightweight or low-resource scenarios, but it lacks many of the advanced features provided by Spring.
ApplicationContext is the preferred choice for most Spring applications, offering support for a variety of features and services that are essential in enterprise applications.


     7. Bean Life Cycles.

     IOC Container Started--->Bean Instantiated--->dependencies injected--->custom init() method()--->custom utility method--->custom destoryed() method

     ->When you write @Autowired Spring IOc Start and first thing i does Instantiated Bean is Instantiated take bean address perform
     dependencies Injection.
     Dependency Injection custom init() run one times utility method going to execute and final destoryed() method of the bean executed
     that object is report then bean life Cycles comes into end.

     8. Session management in SpringBoot.
     1. Creating spring boot project from spring initializer.
     2. Add spring session JDBC dependency in application.properties file.
     3. Add spring session JDBC dependencies in porm.xml.

     9. Session Tracking system.
     Session Tracking is a way to maintains state(data) of an user.

     10. Spring Bean Scope
     Singleton,prototype,request,session,globle session

     11. Actuator: Actuator is used to expose operational information.It is the sub project of spring boot.

     12. Stater tag in SpringBoot
     -> It is the default Configuration of all  hibernate dependency.

     13 important annotations
        @Scope
        Defines scope of bean from one of following:
        • singleton(default)
        • Prototype
        • Request
        • Session
        • Application
        • websocket


       14. Spring Boot Features Overview
        Logging Library:
        Spring Boot automatically provides logging support based on the selected starter dependency (e.g., logback, log4j2). Logging is configured and ready to use, but you can easily override the default settings via configuration properties.

        Internationalization:
        If the messages resource bundle is available at the root of the classpath, Spring Boot provides built-in support for internationalization (i18n). This allows you to manage multilingual content in your application.

        JSON Integration:
        Spring Boot provides integration with JSON mapping libraries (default is Jackson). You can switch to other JSON processors like Gson by adding the appropriate dependencies.

        Testing Support:
        The spring-boot-starter-test dependency includes testing libraries like:

        JUnit for unit testing.
        Spring Test for integration testing.
        Mockito for mocking objects in your tests.
        Starters for Various Use Cases
        Starters are a convenient way to pull in all necessary dependencies for a specific type of application.

        spring-boot-starter-web: Provides dependencies for developing web applications, including RESTful services.
        spring-boot-starter-batch: Includes dependencies needed for batch processing.
        spring-boot-starter-websocket: Adds support for building WebSocket applications.
        Important Terms
        Starters:
        Starters are “one-stop-shop” dependencies that bring in all required libraries for a specific use case without needing to manually search for each library. They follow the naming convention spring-boot-starter-*.

        Examples:
        spring-boot-starter-batch
        spring-boot-starter-data-mongodb
        spring-boot-starter-tomcat
        Configuration Properties:
        These are configuration data files that Spring Boot automatically loads when the application starts. These files can be either inside or outside your packaged JAR and are typically named:

        application.properties
        application-{profile}.properties (for profile-specific configurations)
        Or their YAML equivalents.
        Dependency Injection (DI) or Inversion of Control (IoC):
        In DI, objects define their dependencies, and the Spring container manages the instantiation and injection of those dependencies into beans during runtime.

        Beans:
        A bean is an object that is instantiated, managed, and configured by the Spring IoC container. Beans can be created using annotations, XML configuration, or Java-based configuration.

        Spring Container:
        The Spring container is responsible for creating, configuring, and assembling beans. It follows configuration metadata to determine how to manage the beans. The metadata could be provided via:

        XML
        Annotations
        Java configuration code
        Spring AOP (Aspect-Oriented Programming):
        Spring AOP allows the modularization of cross-cutting concerns like transaction management, security, or logging. It is proxy-based and allows you to apply behavior to multiple objects without modifying their code.

        Aspect: The unit of modularity in AOP (analogous to a class in OOP).


        15.Spring starter available in spring boot.

        spring-boot-starter-thymeleaf: Used to build MVC web applications using Thymeleaf views.
        spring-boot-starter-web-services: Used for Spring Web Services.
        spring-boot-starter-mail: Supports Java Mail and Spring Framework's email sending.
        spring-boot-starter-web: Used for building web applications, including RESTful applications with Spring MVC. Tomcat is the default embedded container.
        spring-boot-starter-integration: Used for Spring Integration.
        spring-boot-starter-test: Provides libraries for testing Spring Boot applications, including JUnit, Hamcrest, and Mockito.
        spring-boot-starter-jdbc: Used for JDBC with Tomcat JDBC connection pooling.
        spring-boot-starter-mobile: Used for building web applications using Spring Mobile.
        spring-boot-starter-validation: Used for Java Bean Validation with Hibernate Validator.
        spring-boot-starter-jersey: Used to build RESTful web applications with JAX-RS and Jersey as an alternative to spring-boot-starter-web.
        spring-boot-starter-data-ldap: Used for Spring Data LDAP.
        spring-boot-starter-aop: Used for aspect-oriented programming with Spring AOP and AspectJ.
        spring-boot-starter-security: Used for Spring Security.
        spring-boot-starter-data-jpa: Used for Spring Data JPA with Hibernate.
        spring-boot-starter: A core starter, including auto-configuration support, logging, and YAML.


        16 .Spring Profiles
            Spring Profiles provide a way to segregate parts of your application configuration and make it only available in certain environments. They help in separating configurations for different environments such as development, testing, staging, and production. Spring profiles can be activated through configuration settings, enabling you to choose which environment-specific settings to apply when the application starts.

            Key Features of Spring Profiles:
            Environment-Specific Configuration:

            With profiles, you can define beans and configurations that are only loaded under specific conditions or environments.
            For example, you may want to use an in-memory database for local development and a MySQL/PostgreSQL database for production.
            Activate Profiles:

            Profiles can be activated using the following:
            application.properties/yaml file.
            JVM system properties (-Dspring.profiles.active=prod).
            Environment variables.
            Programmatically within the application using SpringApplication.setAdditionalProfiles(...).
            Profiles can also be activated from test configurations.
            Profile-Specific Properties Files:

            You can create profile-specific property files, such as:
            application-dev.properties
            application-prod.properties
            application-test.properties
            Spring Boot will automatically pick the right configuration based on the active profile.
            @Profile Annotation:

            You can annotate beans with @Profile("profileName") to conditionally load those beans only when the specified profile is active.
            Example 1: Profile-Specific Property Files
            Suppose you have different environments, such as dev and prod. You can have the following property files:

            application-dev.properties:

            properties
            Copy code
            spring.datasource.url=jdbc:h2:mem:testdb
            spring.datasource.username=sa
            spring.datasource.password=password
            application-prod.properties:

            properties
            Copy code
            spring.datasource.url=jdbc:mysql://prod_db:3306/mydb
            spring.datasource.username=prod_user
            spring.datasource.password=secure_password
            Example 2: Activating Profiles via application.properties
            In the application.properties file, you can set the active profile by using:

            properties
            Copy code
            spring.profiles.active=dev
            This will activate the dev profile, and Spring will load application-dev.properties and corresponding beans defined with the @Profile("dev") annotation.

            Example 3: Using @Profile Annotation in Code
            java
            Copy code
            @Service
            @Profile("dev")
            public class DevDatabaseConfig implements DatabaseConfig {
                // Development environment specific bean configuration
            }

            @Service
            @Profile("prod")
            public class ProdDatabaseConfig implements DatabaseConfig {
                // Production environment specific bean configuration
            }
            In this example:

            The DevDatabaseConfig bean will only be loaded when the dev profile is active.
            The ProdDatabaseConfig bean will only be loaded when the prod profile is active.
            Example 4: Activating Profiles via Command Line
            You can activate a specific profile when starting your application via the command line:

            bash
            Copy code
            java -jar myapp.jar --spring.profiles.active=prod
            This command will activate the prod profile and load the application-prod.properties configuration.

            Benefits of Using Spring Profiles
            Flexibility: Easily switch between different environments without changing code.
            Maintainability: Keep environment-specific configurations separate from the core application logic.
            Testability: Isolate different configuration scenarios for more effective testing.
            Best Practices
            Avoid Hardcoding: Instead of hardcoding active profiles, manage them through environment variables or configuration files.
            Logical Grouping: Use profiles to logically group related configurations for different stages of your application lifecycle, such as dev, qa, and prod.
            Composite Profiles: Combine multiple profiles by specifying them in the spring.profiles.active property, such as spring.profiles.active=dev,local.
            Spring Profiles provide a powerful way to handle environment-specific configuration in a clean and maintainable manner. Let me know if you'd like more information on implementing profiles in your project!

       17. How to connect spring boot with the database?
           Step 1 - Add dependency for your database connector to pom. xml. ...
           Step 2 - Remove H2 Dependency from pom.xml. Or atleast make its scope as test. ...
           Step 3 - Setup your My SQL Database. ...
           Step 4 - Configure your connection to Your Database in application.properties file. ...
           Step 5 - Restart and You are ready!

      18. How to use two database in spring boot?
          spring.user.datasource.url=jdbc:mysql://localhost:3306/user
          spring.user.datasource.username=root
          spring.user.datasource.password=root
          spring.user.datasource.driver-class-name=com.mysql.jdbc.Driver

          spring.booking.datasource.url=jdbc:mysql://localhost:3306/booking
          spring.booking.datasource.username=root
          spring.booking.datasource.password=root
          spring.booking.datasource.driver-class-name=com.mysql.jdbc.Driver


    19. Steps to Use Two Databases in Spring Boot
        Here is how you can configure two data sources in a Spring Boot application:

        Define Properties for Both Data Sources in application.properties
        You can define the configurations for each data source with unique prefixes. For example:

        properties
        Copy code
        # Configuration for User Database
        spring.user.datasource.url=jdbc:mysql://localhost:3306/user
        spring.user.datasource.username=root
        spring.user.datasource.password=root
        spring.user.datasource.driver-class-name=com.mysql.jdbc.Driver

        # Configuration for Booking Database
        spring.booking.datasource.url=jdbc:mysql://localhost:3306/booking
        spring.booking.datasource.username=root
        spring.booking.datasource.password=root
        spring.booking.datasource.driver-class-name=com.mysql.jdbc.Driver
        Create Separate DataSource Beans for Each Database
        You need to create configuration classes for each database to set up and register the beans for DataSource, EntityManagerFactory, and TransactionManager.

        For example, for the User Database:

        java
        Copy code
        @Configuration
        @EnableTransactionManagement
        @EnableJpaRepositories(
            basePackages = "com.example.repository.user",
            entityManagerFactoryRef = "userEntityManagerFactory",
            transactionManagerRef = "userTransactionManager"
        )
        public class UserDataSourceConfig {

            @Primary
            @Bean(name = "userDataSource")
            @ConfigurationProperties(prefix = "spring.user.datasource")
            public DataSource userDataSource() {
                return DataSourceBuilder.create().build();
            }

            @Primary
            @Bean(name = "userEntityManagerFactory")
            public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
                    EntityManagerFactoryBuilder builder,
                    @Qualifier("userDataSource") DataSource userDataSource) {
                return builder
                        .dataSource(userDataSource)
                        .packages("com.example.entity.user")  // Package where User entity classes are located
                        .persistenceUnit("user")
                        .build();
            }

            @Primary
            @Bean(name = "userTransactionManager")
            public PlatformTransactionManager userTransactionManager(
                    @Qualifier("userEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
                return new JpaTransactionManager(userEntityManagerFactory);
            }
        }
        And for the Booking Database:

        java
        Copy code
        @Configuration
        @EnableTransactionManagement
        @EnableJpaRepositories(
            basePackages = "com.example.repository.booking",
            entityManagerFactoryRef = "bookingEntityManagerFactory",
            transactionManagerRef = "bookingTransactionManager"
        )
        public class BookingDataSourceConfig {

            @Bean(name = "bookingDataSource")
            @ConfigurationProperties(prefix = "spring.booking.datasource")
            public DataSource bookingDataSource() {
                return DataSourceBuilder.create().build();
            }

            @Bean(name = "bookingEntityManagerFactory")
            public LocalContainerEntityManagerFactoryBean bookingEntityManagerFactory(
                    EntityManagerFactoryBuilder builder,
                    @Qualifier("bookingDataSource") DataSource bookingDataSource) {
                return builder
                        .dataSource(bookingDataSource)
                        .packages("com.example.entity.booking")  // Package where Booking entity classes are located
                        .persistenceUnit("booking")
                        .build();
            }

            @Bean(name = "bookingTransactionManager")
            public PlatformTransactionManager bookingTransactionManager(
                    @Qualifier("bookingEntityManagerFactory") EntityManagerFactory bookingEntityManagerFactory) {
                return new JpaTransactionManager(bookingEntityManagerFactory);
            }
        }
        Entity Classes for Each Database
        Define your entity classes for each database in separate packages, such as:

        com.example.entity.user for User entities.
        com.example.entity.booking for Booking entities.
        Repository Classes for Each Database
        Similarly, create repositories for each database in separate packages:

        com.example.repository.user for User repositories.
        com.example.repository.booking for Booking repositories.
        Use the Appropriate DataSource in Your Code
        Now, when you autowire a repository, Spring Boot will know which repository to use with which data source based on the configuration. You can perform operations on either of the databases without them interfering with each other.

        Important Considerations:
        @Primary: When configuring multiple data sources, you typically designate one data source as the primary data source using @Primary. This tells Spring Boot which data source to use by default if there is any ambiguity.
        Custom Repositories: Make sure that your repository interfaces are in the correct packages specified in @EnableJpaRepositories.
        Example: Sample Repositories
        UserRepository.java:

        java
        Copy code
        @Repository
        public interface UserRepository extends JpaRepository<User, Long> {
        }
        BookingRepository.java:

        java
        Copy code
        @Repository
        public interface BookingRepository extends JpaRepository<Booking, Long> {
        }
        Now, Spring Boot will know how to handle each repository with its respective data source.

        Testing the Configuration
        You can inject both repositories and test CRUD operations, and each will be executed on its respective database.

        java
        Copy code
        @RestController
        public class TestController {

            @Autowired
            private UserRepository userRepository;

            @Autowired
            private BookingRepository bookingRepository;

            @GetMapping("/test")
            public String test() {
                // Perform operations on userRepository and bookingRepository
                return "Success";
            }
        }
        This will ensure that each database is handled independently by the application using the specified configurations.

       20. What is spring starter parent tag?
           The spring-boot-starter-parent is a project starter. It provides default configurations for our applications. It is used internally by all dependencies. All Spring Boot projects use spring-boot-starter-parent as a parent in pom.xml file.
           Parent Poms allow us to manage the following things for multiple child projects and modules:
           Configuration:It allows us to maintain consistency of Java Version and other related properties.
           Dependency Management:
           It controls the versions of dependencies to avoid conflict.
           Source encoding
           Default Java Version
           Resource filtering
           It also controls the default plugin configuration.
           The spring-boot-starter-parent inherits dependency management from spring-boot-dependencies. We only need to specify the Spring Boot versio

    21. 1. Using application.properties File
        This is the simplest and most common way to change the default port. You just need to add or modify the following property in the application.properties file:

        properties

        server.port=8082
        This will change the default port from 8080 to 8082. The application.properties file is located in the src/main/resources folder.

        2. Using application.yml File
        You can also change the port number in the application.yml file, which is an alternative to application.properties for configuration.

        yaml

        server:
          port: 8082
        This will also change the port to 8082.

        3. Using EmbeddedServletContainerCustomizer Interface (Deprecated)
        Note: As of Spring Boot 2.0, the EmbeddedServletContainerCustomizer interface has been deprecated and replaced by the WebServerFactoryCustomizer interface.

        4. Using WebServerFactoryCustomizer Interface
        You can implement the WebServerFactoryCustomizer interface to programmatically customize the server's configuration, including the port number.


        import org.springframework.boot.web.server.WebServerFactoryCustomizer;
        import org.springframework.boot.web.server.ConfigurableWebServerFactory;
        import org.springframework.stereotype.Component;

        @Component
        public class CustomContainer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8082);
            }
        }
        This approach provides more flexibility and allows you to change other server configurations as well.

        5. Using Command-Line Parameter
        You can also change the port by passing the server.port parameter when running your Spring Boot application from the command line.


        java -jar your-app.jar --server.port=8082
        Alternatively, when running the application via Maven or Gradle:


        mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8082
        Summary
        Best Practice: Use application.properties or application.yml for changing the default port because it's easier to manage and configure.
        Flexibility: Use WebServerFactoryCustomizer if you need programmatic control over the server configuration.
        Quick Override: Use the command-line parameter if you need to change the port quickly for a specific run of the application without modifying configuration files.

        21. How to read application.properties in any class?
        Yes, you can read properties from the application.properties file in a Spring Boot application using various approaches
         like @Value, Environment, or @ConfigurationProperties.
         Below is an explanation of the three methods you mentioned, with code examples for each:

         1. Using the @Value Annotation
         The @Value annotation is the simplest way to inject property values from the application.properties file
         into your Spring components, such as controllers or services.

         app.title=Spring Boot Application
         app.description=This is a simple Spring Boot application.

          @RestController
            public class AppController {

                @Value("${app.title}")
                private String title;

                @Value("${app.description}")
                private String description;

                @GetMapping("/info")
                public String getAppInfo() {
                    return title + ": " + description;
                }
            }
            2. Using Environment Object
            The Environment object is another way to access the properties in Spring Boot.
             This method allows you to programmatically retrieve property values.

            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.core.env.Environment;
            import org.springframework.web.bind.annotation.GetMapping;
            import org.springframework.web.bind.annotation.RestController;

            @RestController
            public class AppController {

                @Autowired
                private Environment env;

                @GetMapping("/info")
                public String getAppInfo() {
                    String title = env.getProperty("app.title");
                    String description = env.getProperty("app.description");
                    return title + ": " + description;
                }
            }

           3. Using @ConfigurationProperties
           The @ConfigurationProperties annotation is useful when you need to map multiple related
           properties into a POJO (Plain Old Java Object). This is particularly helpful when you have a group of related properties.

           app.name=Spring Boot App
           app.version=1.0.0
           app.owner.name=John Doe
           app.owner.email=johndoe@example.com


          Create a Configuration Class:

       import org.springframework.boot.context.properties.ConfigurationProperties;
       import org.springframework.stereotype.Component;

       @Component
       @ConfigurationProperties(prefix = "app")
       public class AppProperties {
           private String name;
           private String version;
           private Owner owner;

           public static class Owner {
               private String name;
               private String email;

               // Getters and setters
               public String getName() { return name; }
               public void setName(String name) { this.name = name; }
               public String getEmail() { return email; }
               public void setEmail(String email) { this.email = email; }
           }

           // Getters and setters
           public String getName() { return name; }
           public void setName(String name) { this.name = name; }
           public String getVersion() { return version; }
           public void setVersion(String version) { this.version = version; }
           public Owner getOwner() { return owner; }
           public void setOwner(Owner owner) { this.owner = owner; }
       }

         Use the Mapped Properties in a Controller:

      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.web.bind.annotation.GetMapping;
      import org.springframework.web.bind.annotation.RestController;

      @RestController
      public class AppController {

          @Autowired
          private AppProperties appProperties;

          @GetMapping("/app-info")
          public String getAppInfo() {
              return appProperties.getName() + " v" + appProperties.getVersion() +
                     ", Owner: " + appProperties.getOwner().getName();
          }
      }

    Summary:
    @Value Annotation: Use it for simple, one-off property injection directly into fields or methods.
    Environment Object: Use it when you need more flexibility to programmatically retrieve property values.
    @ConfigurationProperties: Use it when you need to map a group of related properties into a POJO, especially when dealing with multiple properties under a common prefix.















