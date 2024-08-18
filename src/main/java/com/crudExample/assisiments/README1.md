              
             Here's an assignment for a full-stack developer using Java Spring Boot for the backend and a frontend technology like React or Angular. The assignment involves creating a simple yet functional application that demonstrates your full-stack development skills.

---

## **Full-Stack Developer Assignment: Task Management Application**

### **Objective:**
Create a web application that allows users to manage tasks. Users should be able to create, update, view, and delete tasks. Tasks should be categorized by status (e.g., "To Do", "In Progress", "Completed"). The application should be built using Java Spring Boot for the backend and a frontend framework like React or Angular.

---

### **Requirements:**

### **Backend (Java Spring Boot):**
- **API Endpoints:**
    1. **GET /tasks** - Retrieve a list of all tasks.
    2. **POST /tasks** - Create a new task.
    3. **PUT /tasks/{id}** - Update an existing task.
    4. **DELETE /tasks/{id}** - Delete a task by ID.
    5. **GET /tasks/{id}** - Get details of a specific task by ID.

- **Database Model:**
    - Task:
        - ID (Auto-generated)
        - Title (String)
        - Description (String)
        - Status (Enum: TO_DO, IN_PROGRESS, COMPLETED)
        - Created Date (Timestamp)
        - Updated Date (Timestamp)

- **Technologies:**
    - Spring Boot
    - JPA/Hibernate (for database interaction)
    - MySQL or H2 Database (for testing)
    - Validation (Spring validation)

### **Frontend (React or Angular):**
- **Features:**
    1. **Task List:** Display a list of tasks grouped by status (To Do, In Progress, Completed).
    2. **Task Creation:** Form to create a new task.
    3. **Task Update:** Edit an existing task's details and status.
    4. **Task Deletion:** Ability to delete a task.
    5. **Task Details:** View the details of a specific task.

- **UI Components:**
    - Task List Component
    - Task Form Component (used for both create and update)
    - Task Detail Component

- **Technologies:**
    - React.js (with hooks) or Angular
    - Axios/Fetch API for HTTP requests
    - Bootstrap/Material UI for styling

### **Dummy Data for Testing (Optional):**
- Use the following JSON format for testing in case your backend is not yet connected:
```json
[
  {
    "id": 1,
    "title": "Task 1",
    "description": "This is task 1",
    "status": "TO_DO",
    "createdDate": "2024-08-20T10:00:00Z",
    "updatedDate": "2024-08-21T12:00:00Z"
  },
  {
    "id": 2,
    "title": "Task 2",
    "description": "This is task 2",
    "status": "IN_PROGRESS",
    "createdDate": "2024-08-20T10:00:00Z",
    "updatedDate": "2024-08-21T12:00:00Z"
  }
]
```

### **Bonus Features (Optional):**
- **Authentication:** Implement basic user authentication (Login/Signup) using JWT in the backend and store the token in local storage/session storage on the frontend.
- **Pagination:** Implement pagination for task listing if the number of tasks becomes large.
- **Search:** Add a search bar to filter tasks by title.

---

### **Evaluation Criteria:**
- **Code Quality:** Clean, readable, and well-structured code.
- **Best Practices:** Use of industry-standard coding practices and design patterns (e.g., DTOs, Services, Repositories).
- **Functionality:** Working features as described in the requirements.
- **Scalability:** A codebase that can be easily extended to handle more features.
- **UI/UX:** Intuitive user interface and good user experience.
- **Documentation:** Well-documented code and instructions on how to run the application.

### **Submission:**
- A GitHub repository containing your project code (both backend and frontend).
- A `README.md` file with clear instructions on how to set up and run the application.

--- 

### **Resources to Help You Get Started:**
- [Spring Boot Documentation](https://spring.io/guides/gs/spring-boot/)
- [React.js Documentation](https://reactjs.org/docs/getting-started.html)
- [Angular Documentation](https://angular.io/docs)

This assignment will showcase your full-stack development capabilities, from API creation and database handling on the backend to front-end development and user interface design.