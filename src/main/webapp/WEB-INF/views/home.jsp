<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<title><spring:message code="home.title"/></title>
</head>
<body>
<h4><spring:message code="Label.title"/></h4>
	<a href="?lang=fr">fr</a>
	<a href="?lang=en">en</a>

<h1>
	<spring:message code="home.title"/>
</h1>

<P>  <spring:message code="home.timeOnServer"/> ${serverTime}. </P>
</body>
</html>
