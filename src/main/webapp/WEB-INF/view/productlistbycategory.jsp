<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>productlistbycategory</title>
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
 <td>categoryname</td>
 </tr>
 <c:forEach items="${product}" var="p">
 <tr>
 <td>${p.productname}</td>
 <td>${p.price}</td>
 <td>${p.quantity}</td>
 <td>${p.categoryname}</td>
  <td><a href="/stockmgmt/producteditform">edit / update product</a></td>
  <td><a href="/stockmgmt/deleteproduct/${p.productname}">delete product</a></td>
 </tr>
 </c:forEach>
 <tr>

 </table>
    <table>
                    <tr></tr>

                    <tr>

                        <td></td>

                        <td><a href="/stockmgmt/viewcategorylist">categories</a>

                        </td>

                    </tr>

                </table>
</body>
</html>
