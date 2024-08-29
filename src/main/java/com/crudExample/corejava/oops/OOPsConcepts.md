
     1. Why Java is not a 100% object oriented programming languages?

     Because of primitive data type is not 100% Object Oriented Programming languages.


      Java is not considered a 100% object-oriented programming language primarily because it supports primitive data types (e.g., `int`, `char`, `boolean`, etc.), which are not objects. In a fully object-oriented language, everything is an object, including basic data types.

Here's an example to illustrate this:

```java
public class PrimitiveExample {
    public static void main(String[] args) {
        // Primitive data type
        int number = 10;

        // Object (Wrapper class)
        Integer objectNumber = 10;

        // Displaying both
        System.out.println("Primitive data type: " + number);
        System.out.println("Object (Wrapper class): " + objectNumber);
    }
}
```

In the above code:

- `number` is a primitive data type (`int`), not an object.
- `objectNumber` is an object of the `Integer` wrapper class, which wraps the primitive `int` in an object.

### Explanation in `.md` format:

```markdown
# Why Java is Not 100% Object-Oriented

Java is considered not to be 100% object-oriented because it supports primitive data types such as `int`, `char`, `boolean`, etc. These data types are not objects, which goes against the core principle of object-oriented programming where everything should be an object.

## Example

```java
public class PrimitiveExample {
    public static void main(String[] args) {
        // Primitive data type
        int number = 10;

        // Object (Wrapper class)
        Integer objectNumber = 10;

        // Displaying both
        System.out.println("Primitive data type: " + number);
        System.out.println("Object (Wrapper class): " + objectNumber);
    }
}
```

### Explanation

- **Primitive Data Type:** The variable `number` is of the primitive type `int`, which is not an object in Java.
- **Wrapper Class:** The variable `objectNumber` is an instance of the `Integer` class, which wraps the primitive `int` in an object.

This distinction between primitives and objects is the primary reason why Java is not considered to be fully object-oriented.
```

2. What is OOPs?
 It is a Programming style which is associated with the concept of class and object and various other concepts like.
 Inheritance, Polymorphism,Abstraction ,Encapsulation
 it uses the concept of "objects" and "classes." 
It allows developers to model real-world entities in software,
 making it easier to design, develop, and maintain complex systems.

Features of OOps:
1. Emphasis is on data  than Procedures.
2. Programs are divided into objects.
3. Data Structure are disigned to characterize object.
4. Data is Hidden and external function can not be access.
5. Method operating on the data of an object are tried together is the data structure.


3. Real Time Example of OOps?

  ### Real-Time Example of OOPs: **Bank Account Management System**

Object-Oriented Programming (OOP) principles can be applied to model a bank account management system.
 Here’s how the key OOP concepts like classes, objects, inheritance, polymorphism, abstraction, and encapsulation are used in this example.

#### 1. **Class and Object**
   - **Class**: `BankAccount`
   - **Object**: `customerAccount`, `savingsAccount`, `checkingAccount`

   ```java
   public class BankAccount {
       private String accountNumber;
       private double balance;

       public BankAccount(String accountNumber, double initialBalance) {
           this.accountNumber = accountNumber;
           this.balance = initialBalance;
       }

       public void deposit(double amount) {
           balance += amount;
       }

       public void withdraw(double amount) {
           if(amount <= balance) {
               balance -= amount;
           } else {
               System.out.println("Insufficient balance.");
           }
       }

       public double getBalance() {
           return balance;
       }
   }
   ```

- **Explanation**: The `BankAccount` class is a blueprint that defines the properties (`accountNumber`, `balance`) and methods (`deposit`, `withdraw`, `getBalance`) that all bank account objects will have.

#### 2. **Inheritance**
- **Class**: `SavingsAccount` and `CheckingAccount` extending `BankAccount`

   ```java
   public class SavingsAccount extends BankAccount {
       private double interestRate;

       public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
           super(accountNumber, initialBalance);
           this.interestRate = interestRate;
       }

       public void applyInterest() {
           double interest = getBalance() * interestRate;
           deposit(interest);
       }
   }

   public class CheckingAccount extends BankAccount {
       private double transactionFee;

       public CheckingAccount(String accountNumber, double initialBalance, double transactionFee) {
           super(accountNumber, initialBalance);
           this.transactionFee = transactionFee;
       }

       @Override
       public void withdraw(double amount) {
           super.withdraw(amount + transactionFee);
       }
   }
   ```

- **Explanation**: `SavingsAccount` and `CheckingAccount` classes inherit the properties and behaviors from the `BankAccount` class. They also add or override specific behaviors, demonstrating inheritance.

#### 3. **Polymorphism**
- **Method Overriding**: `withdraw` method in `CheckingAccount`

   ```java
   public class Bank {
       public static void main(String[] args) {
           BankAccount account1 = new SavingsAccount("12345", 1000.0, 0.05);
           BankAccount account2 = new CheckingAccount("67890", 2000.0, 2.0);

           account1.deposit(500);
           account2.withdraw(100);

           System.out.println("Savings Account Balance: " + account1.getBalance());
           System.out.println("Checking Account Balance: " + account2.getBalance());
       }
   }
   ```

- **Explanation**: The `withdraw` method is overridden in `CheckingAccount` to include a transaction fee. The `BankAccount` reference can point to objects of either `SavingsAccount` or `CheckingAccount`, demonstrating polymorphism.

#### 4. **Abstraction**
- **Class**: `BankAccount` (only exposes necessary methods)

- **Explanation**: In the `BankAccount` class, only the methods to deposit, withdraw, and check the balance are exposed. The internal implementation details, such as how the balance is maintained, are hidden from the user, demonstrating abstraction.

#### 5. **Encapsulation**
- **Data Members**: `accountNumber`, `balance`, `interestRate`, `transactionFee`

- **Explanation**: The data members of `BankAccount`, `SavingsAccount`, and `CheckingAccount` are private, meaning they cannot be accessed directly from outside the class. Access is provided through public methods like `deposit`, `withdraw`, and `getBalance`, ensuring that the data is controlled and protected.

### Summary

In this real-time example of a bank account management system:

- **Classes and Objects**: The `BankAccount` class acts as a template for creating various bank account objects.
- **Inheritance**: `SavingsAccount` and `CheckingAccount` inherit from `BankAccount`.
- **Polymorphism**: The `withdraw` method is overridden in the `CheckingAccount` class.
- **Abstraction**: The internal workings of the bank account are abstracted from the user.
- **Encapsulation**: The data related to accounts is encapsulated within the class, ensuring it is secure and only accessible through designated methods.


  1. Object: An entity that has state and behaviours is known as an object.
    5 different ways to create an object in java:
      1.Java new Operator 2. Java class new Instance() method.3. Java new Instance method of Constructor 4.Java object clone() method,6. Java object Serialization and deserilazation.
  2. class: 
    1. Class helps us to generate object.
    2. class will generate object whenever we make a request to class using new keyword.
  3. new keyword.
    1. It is send to request the class to create object.
    2. Once class create an object new keyword gets the address of the object and store in a reference variable.

### Object Creation in Java

#### 1. **Object:**
An object is an instance of a class that has a state (attributes) and behavior (methods). There are five different ways to create an object in Java:

1. **Using `new` Operator**
  - The most common way to create an object is by using the `new` operator.
   ```java
   public class MyClass {
       public void display() {
           System.out.println("Hello from MyClass!");
       }
   }

   public class Main {
       public static void main(String[] args) {
           MyClass obj = new MyClass(); // Using new operator
           obj.display();
       }
   }
   ```

2. **Using `Class.newInstance()` Method**
  - This method creates a new instance of the class represented by this `Class` object.
   ```java
   public class MyClass {
       public void display() {
           System.out.println("Hello from MyClass!");
       }
   }

   public class Main {
       public static void main(String[] args) throws InstantiationException, IllegalAccessException {
           MyClass obj = MyClass.class.newInstance(); // Using Class.newInstance() method
           obj.display();
       }
   }
   ```

3. **Using `Constructor.newInstance()` Method**
  - You can create an object using the reflection API and `Constructor` class.
   ```java
   import java.lang.reflect.Constructor;

   public class MyClass {
       public void display() {
           System.out.println("Hello from MyClass!");
       }
   }

   public class Main {
       public static void main(String[] args) throws Exception {
           Constructor<MyClass> constructor = MyClass.class.getConstructor();
           MyClass obj = constructor.newInstance(); // Using Constructor.newInstance() method
           obj.display();
       }
   }
   ```

4. **Using `clone()` Method**
  - This method creates a new object as a copy of an existing object.
   ```java
   public class MyClass implements Cloneable {
       public void display() {
           System.out.println("Hello from MyClass!");
       }

       @Override
       protected Object clone() throws CloneNotSupportedException {
           return super.clone();
       }
   }

   public class Main {
       public static void main(String[] args) throws CloneNotSupportedException {
           MyClass obj1 = new MyClass();
           MyClass obj2 = (MyClass) obj1.clone(); // Using clone() method
           obj2.display();
       }
   }
   ```

5. **Using Deserialization**
  - Deserialization is the process of converting a byte stream back into an object.
   ```java
   import java.io.*;

   public class MyClass implements Serializable {
       public void display() {
           System.out.println("Hello from MyClass!");
       }
   }

   public class Main {
       public static void main(String[] args) {
           try {
               // Serialize the object
               MyClass obj1 = new MyClass();
               FileOutputStream fos = new FileOutputStream("object.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(obj1);
               oos.close();
               fos.close();

               // Deserialize the object
               FileInputStream fis = new FileInputStream("object.ser");
               ObjectInputStream ois = new ObjectInputStream(fis);
               MyClass obj2 = (MyClass) ois.readObject(); // Using deserialization
               ois.close();
               fis.close();

               obj2.display();
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
       }
   }
   ```

### 2. **Class:**
A class in Java acts as a blueprint for creating objects. It defines the structure and behavior (methods) of the objects.

1. **Class Helps Generate Objects**
  - A class provides the blueprint for creating objects. The class will generate an object whenever we make a request to the class using the `new` keyword.
   ```java
   public class MyClass {
       public void display() {
           System.out.println("This is an object of MyClass!");
       }
   }

   public class Main {
       public static void main(String[] args) {
           MyClass obj = new MyClass(); // Class generates an object
           obj.display();
       }
   }
   ```

2. **Generating Objects Using `new` Keyword**
  - The `new` keyword requests the class to create an object, and once the class creates the object, the `new` keyword returns the reference of the object and stores it in a reference variable.
   ```java
   public class MyClass {
       public void display() {
           System.out.println("This is an object of MyClass created using new keyword!");
       }
   }

   public class Main {
       public static void main(String[] args) {
           MyClass obj = new MyClass(); // Using new keyword to create an object
           obj.display();
       }
   }
   ```

### 3. **New Keyword:**
The `new` keyword in Java is used to create new objects.

1. **Request Class to Create Object**
  - The `new` keyword sends a request to the class to create an object. Once the class creates an object, the `new` keyword returns the address of the object.
   ```java
   public class MyClass {
       public void display() {
           System.out.println("Object created using new keyword.");
       }
   }

   public class Main {
       public static void main(String[] args) {
           MyClass obj = new MyClass(); // new keyword requests the class to create an object
           obj.display();
       }
   }
   ```

2. **Store Object Address in Reference Variable**
  - The `new` keyword gets the address of the newly created object and stores it in a reference variable.
   ```java
   public class MyClass {
       public void display() {
           System.out.println("Object address is stored in the reference variable.");
       }
   }

   public class Main {
       public static void main(String[] args) {
           MyClass obj = new MyClass(); // Address of the object is stored in the reference variable
           obj.display();
       }
   }
   ```




