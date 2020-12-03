<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteEmployee(employeeId)
	{
		if(confirm('Do you want to delete this employee?'))
			{
				var url='delete/'+employeeId;
				window.location.href=url;
			}
	}
</script>
</head>
<body>
    <h3>Employee Success</h3>
    <table border="1">
        <tr>
            <th>Employee Id</th>
            <th>Employee name</th>
            <th>Age</th>
            <th>Salary</th>
            <th>Qualification</th>
            <th>Email</th>
            <th>Date of join</th>
            <th>Action</th>

         </tr>
        <c:forEach items="${employeeList}" var="employee">
        <tr>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.age}</td>
        <td>${employee.salary}</td>
        <td>${employee.qualification}</td>
        <td>${employee.email}</td>
        <td>${employee.doj}</td>
        <%-- <td><a href="<c:url value="/fetchById/${employee.id}"/>">Edit</a>
        	<a href="<c:url value="/delete/${employee.id}"/>">Delete</a>
        </td> --%>
        
       <td>
       		<a href="<c:url value="/fetchById/${employee.id}"/>">
       		<img src="<c:url value='/images/vcard_edit.png'/>" title="Edit Employee"/>
        	</a>
       
        	<img src="<c:url value='/images/vcard_delete.png'/>" title="Delete Employee"
        			onclick="javascript:deleteEmployee(${employee.id})"/>
        
        </td>
        
        </tr>
        </c:forEach>
    </table>

 

</body>
</html>