<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<style>

.btn-group button {
        border: 1px solid;
    padding: 10px;
    margin :20px;
    margin-top: 30px;
    margin-bottom: 20px;
    margin-right: 20px;
    margin-left: 20px;
 box-shadow: 5px 10px 8px #888888;
    background-color: white; 
    border: 1px solid green; 
    color: black; 
    padding: 10px 24px; 
    cursor: pointer; 
    width: 95%; 
    display: block; 
}

.btn-group button:not(:last-child) {
    border-bottom: none; 
}


.btn-group button:hover {
    background-color:  #73d9b2;
}



</style>
</head><body bgcolor="#a3c2c2">
<jsp:include page="header.jsp" flush="true"/>
<form action="" method="post">
<div class="btn-group">
  <button>Upload WFT</button>
  <button>Upload Insight Report</button>
  
  
  <button>Generate Report</button>
</div>
</form>
<jsp:include page="Foot.jsp" flush="true"/>
</body>

</html>