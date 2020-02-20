<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification ToDo</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/ModifierServlet" method="POST">
			<div>
				<span>A faire :</span> <input type="text" id="modif" name="modif" />
				<input type="hidden" name="id" value="" />
			</div>
			<div>
				<input type="checkbox" id="modifOk" name="modifOk" />
				<label>Terminé</label>
			</div>
			<div>
				<input type="submit" id="enregistre" name="enregistre" value="Enregistrer" />
				<input type="submit" id="annule" name="annule" value="Annuler" />
			</div>
		</form>
	</div>
</body>
</html>