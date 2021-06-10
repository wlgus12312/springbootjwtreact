<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>        
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<title>Insert title here</title>
</head>
<script>

	function selectData() {			
		
		$.ajax({
			url:'/test',
			type:'POST',
			dataType:'json',
			data:{
				sel:'kjh'
			},
			success:function(data) { 
			
				var list = data.list;
				
				console.log(list);
																						
			}
		});	
	}


</script>
<body>
	<h1>BrAuction</h1>
	<input type="button" onclick="selectData();" value="조회">
	
	
	
</body>
</html>