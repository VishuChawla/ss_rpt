<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <meta http-equiv="refresh" content="10;URL=<%=request.getContextPath()%>/options" /> -->
<title>loader</title>
<script type="text/javascript">
	function loadDoc() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     	console.log(this.responseText);	 
	     	window.location = "/Report/optionsAfterLoad";
	    }
	  };
	  xhttp.open("GET", "/Report/options", true);
	  xhttp.send();
	}
</script>
<style>
.loader {
	margin-top:10px;
  	border: 5px solid #f3f3f3;
  	border-radius: 50%;
  	border-top: 5px solid #3498db;
  	width: 30px;
  	height: 30px;

  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}



/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

h2{
 color:white;
 margin:30px;
}

</style>
</head>
<jsp:include page="header.jsp" flush="true"/>
<body bgcolor= "a3c2c2" onload="loadDoc()">
<center>
<h2>Please Wait....</h2>

<div class="loader"></div>
</center>

<div id="optionshtml"> </div>

</body>
<jsp:include page="Foot.jsp" flush="true"/>
</html>