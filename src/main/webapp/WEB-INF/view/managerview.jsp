
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manager view</title>
</head>
<body>
 <form:form  id="addcategory" modelAttribute="category" method = "POST" action = "/stockmgmt/addcategory">
      <table>
         <tr>
            <td><form:label path = "categoryname">category Name</form:label></td>
            <td><form:input path="categoryname" name="categoryname" id="categoryname" /></td>
         </tr>
         <tr>
            <td><form:label path = "categorydescription">category description</form:label></td>
            <td><form:input path="categorydescription" name="categorydescription" id="categorydescription" /></td>
         </tr>
         <tr>
            <td colspan = "2">
               <input type = "submit" value = "addcategory"/>
            </td>
         </tr>
          <tr></tr>

                    <tr>

                        <td></td>
						<td> <a href="/stockmgmt/viewcategorylist">show categories</a></td>
						   <td></td>
                        <td><a href="/stockmgmt/home">Home</a>

                        </td>

                    </tr>
      </table>  
   </form:form>
  

</body>

 
</html>