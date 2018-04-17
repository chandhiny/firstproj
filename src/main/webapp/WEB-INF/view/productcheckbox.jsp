<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>productcheckbox</title>
</head>
<body>
<h1>products to buy</h1>
<form:form method="GET" commandName="product" action="/stockmgmt/viewproductlist">
<table>
    <tr>    
    <td>
	  
  <c:forEach items="${productlist}" var="p">
    <form:checkbox path="productname" value="${p.productname}"/>
       ${p.productname}
       <br/>
      
  </c:forEach>
  </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>