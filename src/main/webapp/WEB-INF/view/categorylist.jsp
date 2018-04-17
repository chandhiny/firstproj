<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>categorylist</title>
</head>
<body>
 <table>
 <tr>
 <td colspan="3"><h1>category Information</h1></td>
 </tr>
 <tr>
 <td>categoryname</td>
 <td>categorydescription</td>
 </tr>
 <c:forEach items="${category}" var="p">
 <tr>
 <td><a href="/stockmgmt/getproductbycategoryname/${p.categoryname}">${p.categoryname}</a></td>
 <td>${p.categorydescription}</td>
 </tr>
 </c:forEach>



 </table>
    <table>
                    <tr></tr>

                    <tr>

                        <td></td>
                        <td><a href="/stockmgmt/prodview">add product</a>

                        </td>
						<td><a href="/stockmgmt/viewcategorylist">categories</a></td>
                        <td><a href="/stockmgmt/home">Home</a>

                        </td>

                    </tr>
 <tr></tr>
  <tr>						<td><a href="/stockmgmt/categorydropdown">categories in drop down</a></td>
  </tr>
                </table>
</body>
</html>
