
```markdown
# Encapsulation in Java

## 1. What is Encapsulation?
Encapsulation is the process of wrapping data (variables) and the methods that operate on the data into a single unit, usually called a class. In Java, this is achieved by making the variables of a class private and providing public getter and setter methods to access and update the value of private variables.

- **Example**:
    ```java
    public class Employee {
        private String name; // private variable
        private int age;     // private variable

        // Getter method for name
        public String getName() {
            return name;
        }

        // Setter method for name
        public void setName(String name) {
            this.name = name;
        }

        // Getter method for age
        public int getAge() {
            return age;
        }

        // Setter method for age
        public void setAge(int age) {
            this.age = age;
        }
    }
    ```

## 2. Advantages of Encapsulation:
1. **Control Access to Data**: By using private variables, the data is hidden from outside classes, and access is provided through public methods. This allows for controlled access to the data.
   
2. **Validation**: Before updating a variable, the setter method can include validation logic to ensure the data is correct.

3. **Read-Only/Write-Only Classes**: By only providing a getter method or a setter method, you can make a class read-only or write-only.

## 3. Data Hiding:
Data hiding is a concept where we make the class variables private so that they cannot be accessed directly from outside the class. This ensures that the data is protected and can only be modified through specific methods.

- **Example**:
    ```java
    public class Account {
        private double balance; // private variable

        // Getter method for balance (read-only access)
        public double getBalance() {
            return balance;
        }

        // Setter method for balance with validation
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }
    }
    ```

## 4. How to Achieve Encapsulation in Java?
- **Step 1**: Declare the variables of a class as private.
- **Step 2**: Provide public setter and getter methods to modify and view the variables.

## 5. What are Get and Set Methods?
- **Getter Method**: Returns the value of a private variable.
- **Setter Method**: Sets or updates the value of a private variable.

- **Example**:
    ```java
    public class Student {
        private int rollNumber;

        // Getter method for rollNumber
        public int getRollNumber() {
            return rollNumber;
        }

        // Setter method for rollNumber
        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }
    }
    ```

## 6. Benefits of Encapsulation:
- **Data Hiding**: Protects the data from outside interference and misuse.
- **Increased Flexibility**: Allows changes in the class implementation without affecting other parts of the program.
- **Reusability**: Encapsulated code can be reused easily without exposing internal details.

Encapsulation is a fundamental concept in object-oriented programming that ensures a secure and flexible design by keeping data safe and accessible only through well-defined interfaces.
```

