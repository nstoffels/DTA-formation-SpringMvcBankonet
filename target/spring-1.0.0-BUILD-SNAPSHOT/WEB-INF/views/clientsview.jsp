<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 3 MVC - liste des clients</title>
</head>
<body>
	<h2>Bankonet Spring MVC - Affichages des clients</h2>
	<table border="1">
		<th>
		<td>id</td>
		<td>Prenom</td>
		<td>Nom de famille</td>
		<td>login</td>
		</th>

		<c:forEach items="${clients}" var="cl">
			<tr>
				<td>${cl.id}</td>
				<td>${cl.prenom}</td>
				<td>${cl.nom}</td>
				<td>${cl.login}</td>
			</tr>
		</c:forEach>
	</table>

	<h2>Formulaire nouveaux clients</h2>
	<form:form action="/BankonetSpringMVC/saveClient" modelAttribute="client">

		<table>
			<tr>
				<td>ID client:<f:hidden path="id" /></td>
				<td>${clients.id}</td>
			</tr>
			<tr>
				<td><form:label path="prenom">prenom :</form:label></td>
				<td><form:input path="prenom" /></td>
				<%-- Show errors for prenom field --%>
				<td><form:errors path="prenom" /></td>
			</tr>
			<tr>
				<td><form:label path="nom">nom :</form:label></td>
				<td><form:input path="nom" /></td>
				<%-- Show errors for nom field --%>
				<td><form:errors path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="login">login :</form:label></td>
				<td><form:input path="login" /></td>
				<%-- Show errors for login field --%>
				<td><form:errors path="login" /></td>
			</tr>
			<tr>
				<td><form:label path="motDePasse">Mot de passe :</form:label></td>
				<td><form:input path="motDePasse" /></td>
				<%-- Show errors for motDePasse field --%>
				<td><form:errors path="motDePasse" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>