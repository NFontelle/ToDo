<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo</title>
</head>
<body>
	<h1>ToDo</h1>
	<div>
	
	
	
	
	</div>
	
	
	
	
	
	
	
	
	
	
	<div>
		<form action="${pageContext.request.contextPath}/Connection" method="POST">
			<div>
				<label>Nom utilisateur</label>
				<input type="text" id="utilisateur" name="utilisateur" />
				<br>
				<label>Mot de passe</label>
				<input type="password" id="motDePasse" name="motDePasse" />
			</div>
			<div>
				<input type="submit" value="Se connecter" />
			</div>

		</form>
	</div>
</body>
</html>
