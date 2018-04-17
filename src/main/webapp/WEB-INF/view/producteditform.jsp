<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


 <h1> edit/ update product</h1>  
       <form:form method="POST" modelAttribute="product" action="/stockmgmt/editproductsave">    
        <table >    
          
         <tr>    
          <td>product Name : </td>   
          <td><form:input path="productname"  /></td>  
         </tr>    
         <tr>    
          <td>price :</td>    
          <td><form:input path="price" /></td>  
         </tr>   
         <tr>    
          <td>quantity :</td>    
          <td><form:input path="quantity" /></td>  
         </tr>   
           <tr>    
          <td>category name :</td>    
          <td><form:input path="categoryname" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="update product" /></td>    
         </tr>    
        </table>    
       </form:form>    
       
       
</body>
</html>