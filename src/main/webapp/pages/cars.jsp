<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
   table 
   { border-collapse: collapse; }
   td  
   {   padding: 3px;
       border: 2px solid #9B870C;
   }    
   th  
   {   padding: 4px;
       border: 2px solid blue;
   }
.margin-left{
    margin-left: 20px;
}   
</style> 
<head>
<meta http-equiv="refresh" content="10">

<title>Nordic Cars</title>

<script src="resources/js/nordcar-utils.js"></script>
<script>
	var settCust=new Set();
	<c:forEach var="car" items="${carsList}">
	settCust.add("${car.customer}"); </c:forEach>
</script>
<script>
    var gCtrlFilterS, gCtrlFilterC;
	
	function filterCarTable()
	{
	  filterTable("CarTable", ["Customer", "Status"], [gCtrlFilterC.value, gCtrlFilterS.value]); 
	  storeValue(gCtrlFilterS);
	  storeValue(gCtrlFilterC);
	}

    window.addEventListener("DOMContentLoaded", function ()
	{
	    gCtrlFilterS = document.getElementById('filterStat');
		recallValue(gCtrlFilterS);
        gCtrlFilterS.onchange = filterCarTable;
		
	    gCtrlFilterC = document.getElementById('filterCust');
		toArray(settCust).sort().forEach(function(e){
		    var opt = document.createElement('option');
            opt.value = e;  opt.innerHTML = e;
            gCtrlFilterC.appendChild(opt);
        });
		recallValue(gCtrlFilterC);
        gCtrlFilterC.onchange = filterCarTable;
		filterCarTable();
    });
</script>

</head>
<body>
<h2>Nordic Cars Information</h2>
<!-- ${car} -->
    <div>
    <label>Customer:</label>
        <select id='filterCust'>
            <option value=''>All</option>
        </select>
    <label class="margin-left">Status:</label>
        <select id='filterStat'>
            <option value=''>All</option>
            <option value='Connected'>Connected</option>
            <option value='Disconnected'>Disconnected</option>
        </select>
    </div>
<BR>
<table name="CarTable" align="center" width="90%">
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
            <td>${car.status}</td>
        </tr>
    </c:forEach>
	</tbody>
</table>
</body>
</html>