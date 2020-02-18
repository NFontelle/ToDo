<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="" method="POST">
<table>
<thead>
<tr>
<th>To do</th>
<th>Terminé</th>
<th>Action</th>
</tr>
</thead>
<%--<c:forEach var="" items="">--%>

<tr>
<th>toDo</th>
<th>did</th>
<th><a href="">Modifier</a><a href="">Supprimer</a></th>
</tr>



<%--</c:forEach>--%>








</table>

<input type="submit" id="add" name="add" value="Ajouter ToDo"/>






</form>




</div>

</body>
</html>