<!DOCTYPE html>
<html>
<style>
   table 
   { border-collapse: collapse; }
   td  
   {   padding: 3px;
       border: 2px solid grey;
   }    
   th  
   {   padding: 4px;
       border: 2px solid black;
   }    
</style> 
<head>
<!--meta http-equiv="refresh" content="10"-->
    <title>Cars Activity Emulator</title>
<script>
	function httpGetAsync(theUrl, callback)
	{
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange = function() { 
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
				callback(xmlHttp.responseText);
		}
		xmlHttp.open("GET", theUrl, true); // true for asynchronous 
		xmlHttp.send(null);
	}	
	
    //var arrCars=['VLUR4X20009048066','YS2R4X20005387055','YS2R4X20005388011'];
	var arrCars = new Array();
	function pingCar(vin)
	{
		var dt=new Date();
		httpGetAsync('ping/'+vin+'?time='+dt.getTime(),
		  function(responseText){
			lTime.innerHTML = dt+" : "+responseText;
			loadTable();
		  }
		);
	}
	function loadTable()
	{
		httpGetAsync('data?time='+new Date().getTime(),
		  function(responseText){
			document.getElementById('carDiv').innerHTML = responseText;
			var a=0, b=0, i=0;
			//--GetVins--
			while ((a = responseText.indexOf("add(", a))>-1){
			    b = responseText.indexOf(");", a)
				arrCars[i++] = responseText.substring(a+5, b-1);
				a=b;
			}
		  }
		);
	}
	var j=0;
	var timerPing = setInterval(function(){
	    lTime = document.getElementById('LTime');
		j = Math.floor(Math.random() * 50);
		if (j<arrCars.length)
			pingCar(arrCars[j]);
		loadTable();
	}, 5000);
</script>
</head>
<body>
<h2>Cars Activity Emulator</h2>
    Server Response: <p id="LTime">--- Random Ping ---</p>
<h2>Cars on road</h2>
<div id="carDiv">
Connecting...
</div>
</body>
</html>