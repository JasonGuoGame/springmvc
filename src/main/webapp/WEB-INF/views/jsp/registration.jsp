<%--
  Created by IntelliJ IDEA.
  User: scnyig
  Date: 12/19/2017
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Registration</title>
</head>
<body>
<form:form id="regForm" modelAttribute="user" action="registration" method="post">
  <table align="center">
    <tr>
      <td>
        <form:label path="name">Username</form:label>
      </td>
      <td>
        <form:input path="name" name="username" id="username" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="password">Password</form:label>
      </td>
      <td>
        <form:password path="password" name="password" id="password" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="lastName">LastName</form:label>
      </td>
      <td>
        <form:input path="lastName" name="lastname" id="lastname" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="email">Email</form:label>
      </td>
      <td>
        <form:input path="email" name="email" id="email" />
      </td>
    </tr>
    <%--<tr>
      <td>
        <form:label path="address">Address</form:label>
      </td>
      <td>
        <form:input path="address" name="address" id="address" />
      </td>
    </tr>--%>
    <%--<tr>
      <td>
        <form:label path="phone">Phone</form:label>
      </td>
      <td>
        <form:input path="phone" name="phone" id="phone" />
      </td>
    </tr>--%>
    <tr>
      <td></td>
      <td>
        <form:button id="register" name="register">Register</form:button>
      </td>
    </tr>
    <tr></tr>
    <tr>
      <td></td>
      <td><a href="index.jsp">Home</a>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
