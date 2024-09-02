
                              JSP: JAKARTA SERVER PAGES
Inside JSP we can access partial java code.
Implicit object:session,request,response,out


JSP tags
1. Scriptlet Tag(<% %>)

->In jsp tags can not used access specifier.

->Decleration method not allow.

->Inside scripted code not write html code.

->partial java code.

Implicit object:-> implicit object are like 'out'

request.setAttribute("msg",10);
out.println(request.getAttribute)
response.object
allows session attribute. etc.

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Scriptlet Tags</title>
</head>
<body>
<%
int x = 10;
out.println(x);
%>
</body>
</html>



2. Declaration Tag:
<%!  %>
-> We can used access specifier,method,decleared variable.
-> We can not used implicit object.

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Declaration Tag Example</title>
</head>
<body>
    <%!
        // Declare a global variable
        private int counter = 0;

        // Declare a global method
        public void incrementCounter() {
            counter++;
        }
    %>

    <h1>Counter Value: <%= counter %></h1>

    <button onclick="increment()">Increment Counter</button>

    <script>
        function increment() {
            <% incrementCounter(); %>
            document.getElementsByTagName("h1")[0].innerText = "Counter Value: <%= counter %>";
        }
    </script>
</body>
</html>

3. Expression Tag(<=  >)
-> can write only one statement of code.
->can not used end with semicolumn(;)

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expression Tag Example</title>
</head>
<body>
    <%-- Declare a variable --%>
    <% int x = 10; %>

    <%-- Print the value of the variable using expression tag --%>
    <p>The value of x is: <%= x %></p>

    <%-- Perform arithmetic operation and print result --%>
    <p>The result of 5 + 3 is: <%= 5 + 3 %></p>

    <%-- Accessing request parameter and printing its value --%>
    <p>Hello, <%= request.getParameter("name") %></p>
</body>
</html>

4. Directive Tag(<!@  %>)
->divided into two types: page and include
page directive is use to import any packages into the jsp page.
include directive used to import any file into the page.

/*
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, java.io.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP with Directives</title>
</head>
<body>
    <!-- Page Directive Example -->
    <h2>Page Directive Example</h2>
    <p>This page directive imports the java.util.* and java.io.* packages.</p>

    <%-- Include Directive Example --%>
    <h2>Include Directive Example</h2>
    <p>This include directive includes the content of the header.jsp file:</p>

    <%@ include file="header.jsp" %>

    <p>This is the main content of the JSP page.</p>

    <!-- Include another file -->
    <%@ include file="footer.jsp" %>
</body>
</html>
*/
------->>>>>>>>>>>>>>>>>>>>>
 JSP LIFE CYCLE

                  .jsp                  Request
         JAVA CODE------->jsp Translator------->jsp Init(),jsp Service(),jsp Destroy()(Servlet)
                                       <---------
                                         Response

When java code write in .jsp file with help us to jsp Translator then java code converted into servlet and servlet has three method jspinit(),jspService(),jsp Destroy()
jspinit() run only one's after Tomcat will started.
Service() run any number of time depending on bussiness required.
when Dedtroyed() run it means life cycle of jsp comes to end.





