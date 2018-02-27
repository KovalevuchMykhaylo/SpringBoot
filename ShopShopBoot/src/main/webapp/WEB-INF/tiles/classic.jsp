<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"/></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
     .content {height: 100%}
    
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    footer {
      background-color: black;
      color: white;
      padding: 15px;
    }
  </style>

</head>
<body>

	<tiles:insertAttribute name="header"/>
	
<!-- 	<div class="container">     -->
    	<div class="content text-center">
    		<tiles:insertAttribute name="sidebar"/>
    		
    		<div class="col-md-10 text-center"> 
    			<tiles:insertAttribute name="body"/>
    			
    		</div>
    	</div>
<!--     </div> -->
	
	<tiles:insertAttribute name="footer"/>

</body>
</html>