<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>buyproduct</title>
</head>
<body>
  
                <form:form id="buyproduct" method="POST" modelAttribute="product" action="/stockmgmt/buyproduct">    
        <table >    
          
        <tr>
            <td><form:label path = "productname">product Name</form:label></td>
            <td><form:input path="productname" name="productname" id="productname" /></td>
         </tr>
         <tr>
            <td><form:label path = "quantity">quantity</form:label></td>
            <td><form:input path="quantity" name="quantity" id="quantity" /></td>
         </tr>
            
         <tr>    
          <td> </td>    
          <td><input type="submit" value="buy product" /></td>    
         </tr>   
          <tr></tr>

                    <tr>

                        <td></td>
						<td> <a href="/stockmgmt/viewproductlist">show products</a></td>
						   <td></td>
                        <td><a href="/stockmgmt/home">Home</a>

                        </td>

                    </tr> 
        </table>    
       </form:form>    
</body>
</html>