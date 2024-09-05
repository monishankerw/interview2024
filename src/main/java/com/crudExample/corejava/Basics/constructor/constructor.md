Here’s an explanation of **constructors in Java** along with an example demonstrating constructor overloading, default, parameterized, and non-parameterized constructors.

### Key Points about Constructors:
1. **Constructor Name:** The constructor must have the same name as the class.
2. **Called on Object Creation:** A constructor is called automatically when an object is created.
3. **No Return Type:** Constructors are never allowed to have a return type, not even `void`.
4. **Initialization:** It is primarily used to initialize objects.
5. **Restrictions:** Constructors cannot be `abstract`, `static`, `final`, or `synchronized`.
6. **Parameter List:** A constructor can have no parameters (non-parameterized) or multiple parameters (parameterized).
7. **Exception Handling:** A constructor can throw exceptions.

### Constructor Overloading:
When there is more than one constructor in the same class, but they have different parameter lists (either in the number or type of arguments), it is called constructor overloading.

### Types of Constructors:
1. **Default Constructor:** A no-argument constructor provided by the compiler if none is explicitly defined.
2. **Parameterized Constructor:** A constructor that accepts arguments to initialize object variables.
3. **Non-Parameterized Constructor:** A constructor that doesn't take any arguments.

### Example Code:

```java
class Car {
    String model;
    String color;
    int year;

    // Default constructor (no-argument constructor)
    public Car() {
        this.model = "Unknown";
        this.color = "Unknown";
        this.year = 0;
        System.out.println("Default Constructor Called");
    }

    // Parameterized constructor
    public Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
        System.out.println("Parameterized Constructor Called");
    }

    // Non-parameterized constructor
    public Car(String model) {
        this.model = model;
        this.color = "Default Color";
        this.year = 2023;  // Default year
        System.out.println("Non-Parameterized Constructor Called");
    }

    // Constructor that throws an exception
    public Car(int year) throws Exception {
        if (year < 1885 || year > 2024) {
            throw new Exception("Invalid year for a car");
        }
        this.year = year;
        System.out.println("Constructor with Exception Called");
    }

    public void display() {
        System.out.println("Model: " + model + ", Color: " + color + ", Year: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        // Using default constructor
        Car car1 = new Car();
        car1.display();

        // Using parameterized constructor
        Car car2 = new Car("Tesla", "Red", 2022);
        car2.display();

        // Using non-parameterized constructor
        Car car3 = new Car("Ford");
        car3.display();

        // Using constructor with exception handling
        try {
            Car car4 = new Car(1800);  // This will throw an exception
            car4.display();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
```

### Output:
```
Default Constructor Called
Model: Unknown, Color: Unknown, Year: 0
Parameterized Constructor Called
Model: Tesla, Color: Red, Year: 2022
Non-Parameterized Constructor Called
Model: Ford, Color: Default Color, Year: 2023
Exception: Invalid year for a car
```

### Key Points in the Example:
1. **Default Constructor**: Initializes the car with default values.
2. **Parameterized Constructor**: Initializes the car with provided values.
3. **Non-Parameterized Constructor**: Uses default values for some attributes but accepts a model name.
4. **Constructor with Exception**: Checks if the provided year is valid and throws an exception if not.

This demonstrates the versatility and functionality of constructors in Java, including overloading.