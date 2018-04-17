<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>category drop down</h1>
Select category to view products:
<form:form method="GET" commandName="category" action="/stockmgmt/getproductbycategoryname">
<table>
    <tr>    
    <td>
        <ul>                  
                  <select name="categoryname">
  <c:forEach items="${categorylist}" var="c">
    <option value="${c.categoryname}">
        ${c.categoryname}
    </option>
  </c:forEach>
</select>
        </ul>
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