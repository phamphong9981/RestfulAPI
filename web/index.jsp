<%--
  Created by IntelliJ IDEA.
  User: Pham Phong
  Date: 7/29/2020
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Register as new customer</h3>

  <form action="/customers" method="post" >
    <pre>
           Name  <input type="text" name="name" /><br/>
         Address <input type="text" name="address" /><br/>
    Phone Number <input type="text" name="phone-number" /><br/>
                         <input type="submit" value="Submit" />
    </pre>
  </form>
  </body>
</html>
