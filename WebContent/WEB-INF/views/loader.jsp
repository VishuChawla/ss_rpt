<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loader</title>
<style>
.loader {
margin-top:200px;
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;

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
<body bgcolor= "a3c2c2">
<center>
<h2>Please Wait</h2>

<div class="loader"></div>
</center>
</body>
<jsp:include page="Foot.jsp" flush="true"/>
</html>