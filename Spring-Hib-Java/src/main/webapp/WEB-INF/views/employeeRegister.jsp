<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration Page</title>
</head>
<body>
    <h3>Employee Registration Form</h3>
    <c:url var="action" value="/saveEmp"></c:url>
    <form:form action="${action}" method="post" commandName="empForm" novalidate="novalidate">
        <table>
            <tr>
                <td>Employee Name:</td>
                <td><form:input path="name" /><font color="red"><form:errors path="name"/></font></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" /><font color="red"><form:errors path="age"/></font></td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td><form:input path="salary" /><font color="red"><form:errors path="salary"/></font></td>
            </tr>
            <tr>
                <td>Qualification:</td>
                <td><form:input path="qualification" /><font color="red"><form:errors path="qualification"/></font></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input type="email" path="email" /><font color="red"><form:errors path="email"/></font></td>
            </tr>
            <tr>
                <td>Date of Join:</td>
                <td><form:input type="date" path="doj" /><font color="red"><form:errors path="doj"/></font></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add Employee" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>