<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<head>
	<title>${pageName }</title>
</head>
<body>
	${pageName}

	<div id="root"></div>
	<script src="/js/react/${pageName}.bundle.js"></script>
</body>
</html>