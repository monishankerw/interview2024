```markdown
# Compile-Time Polymorphism in Java

## Overview
Compile-time polymorphism in Java, also known as static polymorphism or early binding, 
is achieved through **method overloading**. Method overloading allows multiple methods in the same class to have the same name but different parameter lists.

### Key Concepts:
1. **Method Overloading**: Creating multiple methods in the same class with the same name but different parameters.
2. **Static Methods**: Method overloading can be applied to static methods as well.

## Method Overloading
Method overloading allows a class to have more than one method with the same name, provided their parameter lists are different. The differences can be in the:
1. **Number of Parameters**: The methods can have different numbers of parameters.
2. **Type of Parameters**: The methods can accept parameters of different types.
3. **Order of Parameters**: The order of parameters in the method signature can be different.

### Example:
```java
public class A {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.add(10, 20));        // Calls add(int, int)
        System.out.println(obj.add(10, 20, 30));    // Calls add(int, int, int)
        System.out.println(obj.add(10.5, 20.5));    // Calls add(double, double)
    }
}
```

### Output:
```
30
60
31.0
```

### Key Points:
- **Overloading Static Methods**: Yes, static methods can be overloaded.
- **Overloading with Different Return Types**: Method overloading cannot be done by changing the return type alone. The parameter list must differ.

## Frequently Asked Questions on Compile-Time Polymorphism

### 1. **Can we overload methods that differ only by the static keyword?**
- **Answer**: No, overloading methods that differ only by the `static` keyword is not possible. The parameter list must differ.

### 2. **Can we overload methods with different return types?**
- **Answer**: No, overloading based only on return types is not allowed in Java. The parameter list must be different for method overloading.

### 3. **Can we overload a method by changing only the order of parameters?**
- **Answer**: Yes, you can overload a method by changing the order of parameters.

### 4. **Can we overload the main method in Java?**
- **Answer**: Yes, the `main` method can be overloaded, but the JVM will only call the standard `main(String[] args)` method when starting the application.

### 5. **What happens if we overload methods with different parameter lists and same return type?**
- **Answer**: The correct method is determined at compile-time based on the method signature used when calling the method.

## Summary
- **Compile-time polymorphism** is achieved through method overloading.
- **Method overloading** allows a class to have multiple methods with the same name but different parameter lists.
- **Static methods** can also be overloaded, but overloading cannot be achieved by changing only the return type or using the `static` keyword alone.

Compile-time polymorphism enhances code readability and reusability by allowing multiple methods with similar functionality to be grouped under a single method name.
```

