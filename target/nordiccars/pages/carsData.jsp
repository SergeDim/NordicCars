<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<!--meta http-equiv="refresh" content="10"-->

<title>Nordic Cars Data</title>
<script>
	var listVins=new List();
	<c:forEach var="car" items="${carsList}">
	listVins.add("${car.vin}"); </c:forEach>
</script>
</head>
<body>
<table name="CarTable">
    <thead> <tr>
        <th>VIN</th>
        <th>Reg Nr.</th>
        <th>Customer</th>
        <th>Status</th>
    </tr> </thead>
	<tbody>
    <c:forEach var="car" items="${carsList}">
        <tr>
            <td>${car.vin}</td>
            <td>${car.regNum}</td>
            <td>${car.customer}</td>
            <td onClick="pingCar('${car.vin}')"><u>${car.status}</u></td>
        </tr>
    </c:forEach>
	</tbody>
</table>
</body>
</html>