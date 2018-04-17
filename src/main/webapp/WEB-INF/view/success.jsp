<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>
</head>
<body>
 <table>
 <tr>
 <td colspan="3"><h1>product Information</h1></td>
 </tr>
 <tr>
 <td>productname</td>
 <td>price</td>
 <td>quantity</td>
 </tr>
 <c:forEach items="${product}" var="p">
 <tr>
 <td>${p.productname}</td>
 <td>${p.price}</td>
 <td>${p.quantity}</td>
 </tr>
 </c:forEach>
 <tr>

 </table>
    <table>
                    <tr></tr>

                    <tr>

                        <td></td>

                        <td><a href="/stockmgmt/home">Home</a>

                        </td>
<td><a href="/stockmgmt/productbuy">buy products</a>

                        </td>

                    </tr>

                </table>
                
              
</body>
</html>
