/* *** COLLECTIONS *** */

function toArray(collection)
{
  var i=0;
  var arr=new Array(collection.size);
  collection.forEach( function (e) {arr[i++]=e;} );
  return arr;
}

/* *** COOKIES *** */

function setCookie(c_name, value, exdays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
    document.cookie = c_name + "=" + c_value;
}

function getCookie(c_name) {
    var c_value = document.cookie;
    var c_start = c_value.indexOf(" " + c_name + "=");
    if (c_start == -1) {
        c_start = c_value.indexOf(c_name + "=");
    }
    if (c_start == -1) {
        c_value = null;
    } else {
        c_start = c_value.indexOf("=", c_start) + 1;
        var c_end = c_value.indexOf(";", c_start);
        if (c_end == -1) {
            c_end = c_value.length;
        }
        c_value = unescape(c_value.substring(c_start, c_end));
    }
    return c_value;
}

function storeValue(input) {
    var name = input.id;
    var value = input.value;
    setCookie(name, value, 1);
}

function recallValue(input) {
    var name = input.id;
    var val = getCookie(name);
	if (val != null)
		input.value = val
		else input.value = '';
    return val;
}

/* *** Filter table by arrColumns, arrValues *** */

function filterTable(sTableName, arrColumns, arrValues)
{
	var tables = document.getElementsByName(sTableName);
	if (tables==null || tables.length<1) return;
	
	var heads = tables[0].querySelectorAll('table th');

	var arrHeadText = new Array(heads.length);
	for (var i=0; i < heads.length; i++)
		arrHeadText[i] = heads[i].innerText;

	var headidxs = new Array(arrColumns.length);
	for (var i=0, j=0; i < arrColumns.length; i++)
	{
	  var idx = arrHeadText.indexOf(arrColumns[i]);
	  if (idx > -1)
		headidxs[j++] = idx;
	}
	
	var rows = tables[0].querySelectorAll('table tr');
	for (var i = 0; i < rows.length; i++) {
		var	cells = rows[i].querySelectorAll('td');
		var exist = true;
		if (cells.length>0)
		  for (var j=0; j<arrColumns.length; j++) {
			var iCol = headidxs[j];
			exist = exist && (cells[iCol].innerText == arrValues[j] || arrValues[j] == '');
		  }
		if (exist) { rows[i].style.display = 'table-row' }
		else { rows[i].style.display = 'none' };
	};
};

/* Filter by only sColumn */
function filterTableByCol(sTableName, sColumn, filter)
{
	var tables = document.getElementsByName(sTableName);
	if (tables==null || tables.length<1) return;
	
	var heads = tables[0].querySelectorAll('table th');
	var headidx = -1;
	for (var i=0; i < heads.length; i++)
	  if (sColumn == heads[i].innerText)
		headidx=i;
	
	var rows = tables[0].querySelectorAll('table tr');
	for (var i = 0; i < rows.length; i++) {
		var	cells = rows[i].querySelectorAll('td');
		var exist = cells.length==0;
		exist = exist || (cells[headidx].innerText == filter || filter == '');
		if (exist) { rows[i].style.display = 'table-row' }
		else { rows[i].style.display = 'none' };
	};
};

/* Filter all the rows/cols, including headers */
function filterTableAll(sTableName, filter)
{
	var tables = document.getElementsByName(sTableName);
	if (tables==null || tables.length<1) return;
	
	var rows = tables[0].querySelectorAll('table tr');
	for (var i = 0; i < rows.length; i++) {
		var exist = false,
			cells = rows[i].querySelectorAll('td');
		for (var j = 0; j < cells.length; j++) {
			exist = exist || (cells[j].innerText == filter || filter == '');
		};
		if (exist) { rows[i].style.display = 'table-row' }
		else { rows[i].style.display = 'none' };
	};
};

/* View in fullscreen */
function openFullscreen() {
  /* Get the documentElement (<html>) to display the page in fullscreen */
  var elem = document.documentElement;
	
  if (elem.requestFullscreen) {
    elem.requestFullscreen();
  } else if (elem.mozRequestFullScreen) { /* Firefox */
    elem.mozRequestFullScreen();
  } else if (elem.webkitRequestFullscreen) { /* Chrome, Safari and Opera */
    elem.webkitRequestFullscreen();
  } else if (elem.msRequestFullscreen) { /* IE/Edge */
    elem.msRequestFullscreen();
  }
}

/* Close fullscreen */
function closeFullscreen() {
  if (document.exitFullscreen) {
    document.exitFullscreen();
  } else if (document.mozCancelFullScreen) { /* Firefox */
    document.mozCancelFullScreen();
  } else if (document.webkitExitFullscreen) { /* Chrome, Safari and Opera */
    document.webkitExitFullscreen();
  } else if (document.msExitFullscreen) { /* IE/Edge */
    document.msExitFullscreen();
  }
}