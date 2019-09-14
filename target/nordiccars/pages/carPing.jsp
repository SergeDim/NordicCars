<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Acknoweledge Ping</title>
</head>
<body>
    <c:if test="${!empty car}">
	We hear you, Vehicle Nr 
	<b>${car.vin} / ${car.regNum}</b>
    </c:if>
    <c:if test="${empty car}">
	<b color="red">Vehicle Not found!</b>
    </c:if>
</body>
</html>