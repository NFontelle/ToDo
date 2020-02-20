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
		<form action="${pageContext.request.contextPath}/nouveau.jsp" method="GET">
			<table>
				<thead>
					<tr>
						<th>To do</th>
						<th>Terminé</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach var="t" items="${listeToDo}">
				<input type="hidden" name="id" value="${t.id}"/>
				<tr>
					<th>${t.contenu}</th>
					<th>contenu todo</th>
					<th><input type="checkbox" id="termine" name="termine" /></th>
					<th><a href="${pageContext.request.contextPath}/modification.jsp">Modifier</a><a href="${pageContext.request.contextPath}/SupprimerServlet">Supprimer</a></th>
				</tr>
				</c:forEach>
			</table>
			<input type="submit" id="add" name="add" value="Ajouter ToDo" />
		</form>
	</div>

</body>
</html>