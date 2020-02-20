<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/AjouterServlet" method="POST">
			<div>
				<span>A faire :</span> <input type="text" id="contenu" name="contenu" />
			</div>
			<div>
				<input type="submit" id="enregistre" name="enregistre" value="Enregistrer" />
				<input type="reset" id="annule"	name="annule" value="Annuler" />
			</div>
		</form>
	</div>
</body>
</html>